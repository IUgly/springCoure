package com.example.demo.enums;

import lombok.Data;

/**
 * @author kuangjunlin
 */
public enum UniResponseEnums {
    /**
     * 请求成功
     */
    SUCCESS(0,"success"),
    /**
     * 数据库异常
     */
    DATABASE_ERROR(-1, "database error"),
    /**
     * 不合法请求方式
     */
    ILLEGAL_REQUEST(-2, "request's parameter is illegal");

    private int status;
    private String message;

    UniResponseEnums(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
