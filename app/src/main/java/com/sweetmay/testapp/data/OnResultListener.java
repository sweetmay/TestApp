package com.sweetmay.testapp.data;

import retrofit2.Response;

public interface OnResultListener {
    void onResult(Response<DataRequest> response);
}
