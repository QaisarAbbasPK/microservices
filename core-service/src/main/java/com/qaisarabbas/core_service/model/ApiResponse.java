package com.qaisarabbas.core_service.model;


import com.qaisarabbas.core_service.util.ApiStatus;

public class ApiResponse {
    public int status = ApiStatus.SUCCESS;
    public String message = ApiStatus.SUCCESS_MESSAGE;
    public Object data;

    public ApiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiResponse(Object data) {
        this.data = data;
    }

}
