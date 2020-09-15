package com.sweetmay.testapp.data;

import android.os.Handler;

import com.sweetmay.testapp.data.DataRequest;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetData {

    private final static String BASE_URL = "http://www.mocky.io/";
    private DataCall dataCall;
    private Handler handler;

    public GetData() {
        handler = new Handler();
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        dataCall = retrofit.create(DataCall.class);
    }

    public void request(final OnResultListener onResultListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Response<DataRequest> response = dataCall.loadData().execute();
                    if(response.body() != null && response.isSuccessful()){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                onResultListener.onResult(response);
                            }
                        });
                    }else{
                        throw new IOException();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
