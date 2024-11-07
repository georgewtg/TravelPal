package com.rpl2jumat.travelpal.model;

public class BaseResponse<T> {
    public boolean success;
    public String message;
    public T payload;
}
