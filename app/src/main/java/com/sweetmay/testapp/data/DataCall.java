package com.sweetmay.testapp.data;


import retrofit2.Call;
import retrofit2.http.GET;

public interface DataCall {
    @GET("v2/5ddcd3673400005800eae483")
    Call<DataRequest> loadData();
}
