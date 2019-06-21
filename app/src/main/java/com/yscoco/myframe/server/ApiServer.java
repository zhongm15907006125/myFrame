package com.yscoco.myframe.server;

import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author：ZhongM on 2019/6/14 11:09
 */
public interface ApiServer {

    @POST("user/login")
    Observable<BaseDTO<BaseDataDTO>> login(@Query("username") String phone, @Query("password") String password);

    @POST("user/register")
    Observable<BaseDTO<List<String>>> register(@Query("username") String username, @Query("password") String password,@Query("repassword") String repassword);

    @POST("user/login")
    Observable<BaseDTO<List<String>>> sendSms(@Query("mobile") String phone);
}
