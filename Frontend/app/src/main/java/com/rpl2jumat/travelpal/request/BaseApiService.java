package com.rpl2jumat.travelpal.request;

import com.rpl2jumat.travelpal.model.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {
    @GET("/status")
    Call<BaseResponse<String>> getStatus();
}
