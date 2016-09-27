package com.example.kuybeer26092016.retrofittest01.Httpcallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by peerapong on 20/9/2559.
 */
public interface Service {

    @POST("/service/json/peerapong/JsonNew250959.php")
    Call<List<Mis_mclist>> CallbackTest();
}
