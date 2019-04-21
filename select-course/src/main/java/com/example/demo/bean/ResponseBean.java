package com.example.demo.bean;

import com.example.demo.enums.UniResponseEnums;
import lombok.Data;

/**
 * @author kuangjunlin
 */
@Data
public class ResponseBean <T> {
    private T data;
    private int status;
    private String message;

    public ResponseBean(T data, int status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public ResponseBean(UniResponseEnums uniResponseEnums, T data) {
        this.status = uniResponseEnums.getStatus();
        this.message = uniResponseEnums.getMessage();
        this.data = data;
    }

    public ResponseBean(UniResponseEnums uniResponseEnums) {
        this.status = uniResponseEnums.getStatus();
        this.message = uniResponseEnums.getMessage();
    }
}
