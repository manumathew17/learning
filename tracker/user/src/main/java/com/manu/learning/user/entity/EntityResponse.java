package com.manu.learning.user.entity;

import lombok.Data;

@Data
public class EntityResponse {
    private int status;
    private String message;
    private String data;

    public EntityResponse(int status, String message, String data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
