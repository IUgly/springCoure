package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private StudentDao studentDao;

    public String userListService(){

        Gson gson = new Gson();
        return gson.toJson(this.studentDao.selectUsers());
    }

}
