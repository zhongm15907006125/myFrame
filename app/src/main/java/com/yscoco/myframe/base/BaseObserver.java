package com.yscoco.myframe.base;

/**
 * @author：ZhongM on 2019/6/15 16:05
 */

import android.net.ParseException;
import android.util.Log;

import com.google.gson.JsonParseException;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * File descripition:   数据处理基类
 *
 * @author lp
 * @date 2018/6/19
 */
public abstract class BaseObserver<T> extends DisposableObserver<T> {
    /**
     * 于服务器约定  返回code为几是正常请求
     */
    public static final int CODE = BaseConfig.baseCode;
    protected BaseContract.BaseView view;
    /**
     * 网络连接失败  无网
     */
    public static final int NETWORK_ERROR = 100000;
    /**
     * 解析数据失败
     */
    public static final int PARSE_ERROR = 1008;
    /**
     * 网络问题
     */
    public static final int BAD_NETWORK = 1007;
    /**
     * 连接错误
     */
    public static final int CONNECT_ERROR = 1006;
    /**
     * 连接超时
     */
    public static final int CONNECT_TIMEOUT = 1005;
    public BaseObserver(BaseContract.BaseView view) {
        this.view = view;
    }

    @Override
    protected void onStart() {
        Log.e("BaseObserver","onStart");
        if (view != null) {
            view.showLoading();
        }
    }
    @Override
    public void onNext(T o) {
        Log.e("BaseObserver","onNext");
        try {
            // loading写到这里没有延迟效果
            if (view != null) {
                view.hideLoading();
            }
            BaseDTO model = (BaseDTO) o;
//            next(o);
            if (model.getCode() == CODE) {
                onSuccess(o);
            } else {
                if (view != null) {
                    view.onErrorCode(model);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            onError(e.toString());
        }
    }
    @Override
    public void onError(Throwable e) {
        Log.e("BaseObserver","onError");
        if (view != null) {
            view.hideLoading();
        }
        if (e instanceof HttpException) {
            //   HTTP错误
            onExceptions(BAD_NETWORK, "");
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {
            //   连接错误
            onExceptions(CONNECT_ERROR, "");
        } else if (e instanceof InterruptedIOException) {
            //  连接超时
            onExceptions(CONNECT_TIMEOUT, "");
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            //  解析错误
            onExceptions(PARSE_ERROR, "");
            e.printStackTrace();
        }  else {
            if (e != null) {
                onError(e.toString());
            } else {
                onError("未知错误");
            }
        }
    }
    /**
     * 中间拦截一步  判断是否有网络  为确保准确  此步去除也可以
     *
     * @param unknownError
     * @param message
     */
//    private void onException(int unknownError, String message) {
//        BaseDTO model = new BaseDTO(message, unknownError);
//        if (!NetWorkUtils.isAvailableByPing()) {
//            model.setErrcode(NETWORK_ERROR);
//            model.setErrmsg("网络不可用，请检查网络连接！");
//        }
//        onExceptions(model.getErrcode(), model.getErrmsg());
//        if (view != null) {
//            view.onErrorCode(model);
//        }
//    }
    private void onExceptions(int unknownError, String message) {
        switch (unknownError) {
            case CONNECT_ERROR:
                onError("连接错误");
                break;
            case CONNECT_TIMEOUT:
                onError("连接超时");
                break;
            case BAD_NETWORK:
                onError("网络超时");
                break;
            case PARSE_ERROR:
                onError("数据解析失败");
                break;
            //网络不可用
            case NETWORK_ERROR:
                onError("网络不可用，请检查网络连接！");
                break;
            default:
                break;
        }
    }
    //loading消失写到这 有一定的延迟  对dialog显示有影响
    @Override
    public void onComplete() {
       /* if (view != null) {
            view.hideLoading();
        }*/
    }
    public abstract void onSuccess(T o);
    public void onError(String msg){
        view.showError(msg);
    }
//    public abstract void next(T o);
}
