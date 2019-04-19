package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.IReptileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kuangjunlin
 */
@RestController
public class Control {
    @Autowired
    private IReptileService service;

    @PostMapping(value = "hello", produces = "application/json")
    public String hello(@RequestBody JSONObject json){
        return json.toString();
    }

    @GetMapping(value = "userList", produces = "application/json")
    public String users(){
        return "";
    }
}
