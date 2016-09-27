package com.example.kuybeer26092016.retrofittest01.Control;

import com.example.kuybeer26092016.retrofittest01.Httpcallback.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by peerapong on 20/9/2559.
 */
public class Manager_Retrofit {
    private static final String BASE_URL = "http://www.thaidate4u.com/";
    private Service mService;
    public Service getmService(){
            if(mService == null){
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                mService = retrofit.create(Service.class);
            }
        return mService;
    }


}
