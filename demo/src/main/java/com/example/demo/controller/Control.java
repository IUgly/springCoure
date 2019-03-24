package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.Dao;
import com.example.demo.dao.StudentDao;
import com.example.demo.service.Service;
import com.example.demo.vo.Student;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Control {
    @Autowired
    private Service service;

    @PostMapping(value = "hello", produces = "application/json")
    public String hello(@RequestBody JSONObject json){
        return json.toString();
    }

    @GetMapping(value = "userList", produces = "application/json")
    public String users(){
        return this.service.userListService();
    }
}
