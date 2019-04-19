package com.example.demo.enums;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;

/**
 * @author kuangjunlin
 */
public enum Singleton {

    /**
     * 单例模式
     * restTemplate
     * gson
     */
    INSTANCE;
    private RestTemplate restTemplate;
    private Gson gson;

    Singleton(){
        this.gson = new Gson();
        this.restTemplate = new RestTemplate();
    }
    public RestTemplate getRestTemplate(){
        return this.restTemplate;
    }
    public Gson getGson(){
        return this.gson;
    }

}
