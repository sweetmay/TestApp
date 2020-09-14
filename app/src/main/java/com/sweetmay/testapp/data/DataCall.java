package com.sweetmay.testapp.data;

import com.sweetmay.testapp.DataRequest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataCall {
    @GET("v2/56fa31e0110000f920a72134")
    Call<DataRequest> loadData();
}
