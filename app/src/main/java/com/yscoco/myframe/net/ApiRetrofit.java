package com.yscoco.myframe.net;


import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.yscoco.myframe.App;
import com.yscoco.myframe.Constant;
import com.yscoco.myframe.base.BaseConfig;
import com.yscoco.myframe.server.ApiServer;
import com.yscoco.myframe.util.StringUtil;

import java.io.IOException;
import java.net.CookieManager;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author：ZhongM on 2019/6/14 11:07
 */
public class ApiRetrofit {
    public final String BASE_SERVER_URL = BaseConfig.baseUrl;
    private String TAG = "ApiRetrofit %s";
    private static ApiRetrofit apiRetrofit;
    private Retrofit retrofit;
    private ApiServer apiServer;
    private static Gson gson;
    private static final int DEFAULT_TIMEOUT = 15;


    public ApiRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder .addInterceptor(interceptor)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加json转换框架
                //支持RxJava2
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        apiServer = retrofit.create(ApiServer.class);
    }

    public static ApiRetrofit getInstance() {
        if (apiRetrofit == null) {
            synchronized (Object.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new ApiRetrofit();
                }
            }
        }
        return apiRetrofit;
    }

    public ApiServer getApiService() {
        return apiServer;
    }

    private Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl.Builder builder = request.url().newBuilder();
            builder.addQueryParameter("app_key",Constant.app_key);
            String token = App.getInstance().getToken();
            if (!StringUtil.isEmpty(token)) {
                builder.addQueryParameter("token",token);
            }
            request = request.newBuilder()
                    .url(builder.build())
                    .build();
            long startTime = System.currentTimeMillis();
            Response response = chain.proceed(request);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            MediaType mediaType = response.body().contentType();
            String content = response.body().string();
//            analyzeJson("data", "", content);
            Logger.wtf(TAG, "----------Request Start----------------");
            printParams(request.body());
            Logger.e(TAG, "| " + request.toString() + "===========" + request.headers().toString());
            Logger.json(content);
            Log.d(TAG,content);
            Logger.wtf(TAG, "----------Request End:" + duration + "毫秒----------");

            return response.newBuilder()
                    .body(ResponseBody.create(mediaType, content))
                    .build();
        }
    };

    /**
     * 请求参数日志打印
     *
     * @param body
     */
    private void printParams(RequestBody body) {
        if (body != null) {
            Buffer buffer = new Buffer();
            try {
                body.writeTo(buffer);
                Charset charset = Charset.forName("UTF-8");
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(charset);
                }
                String params = buffer.readString(charset);
                Logger.e(TAG, "请求参数： | " + params);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
