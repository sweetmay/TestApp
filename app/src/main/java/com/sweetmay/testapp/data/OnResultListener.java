package com.sweetmay.testapp.data;

import com.sweetmay.testapp.DataRequest;

import retrofit2.Response;

public interface OnResultListener {
    void onResult(Response<DataRequest> response);
}
