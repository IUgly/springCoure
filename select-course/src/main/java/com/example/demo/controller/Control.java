package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.ResponseBean;
import com.example.demo.enums.Singleton;
import com.example.demo.enums.UniResponseEnums;
import com.example.demo.service.IPickService;
import com.example.demo.service.IReptileService;
import com.example.demo.vo.Course;
import com.example.demo.vo.Record;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kuangjunlin
 */
@RestController
public class Control {
    @Autowired
    private IPickService iPickService;
    private final Gson gson = Singleton.INSTANCE.getGson();

    @PostMapping(value = "addCourse", produces = "application/json")
    public String pickCourse(String courseId, String studentId){
        if (this.iPickService.addRecord(new Record(courseId, studentId))) {
            return this.gson.toJson(new ResponseBean<>(UniResponseEnums.SUCCESS));
        }else {
            return this.gson.toJson(new ResponseBean<>(UniResponseEnums.DATABASE_ERROR));
        }
    }

    @PostMapping(value = "deleteCourse", produces = "application/json")
    public String deleteCourse(String studentId, String courseId){
        if (this.iPickService.deleteRecord(studentId, courseId)) {
            return this.gson.toJson(new ResponseBean<>(UniResponseEnums.SUCCESS));
        }else {
            return this.gson.toJson(new ResponseBean<>(UniResponseEnums.DATABASE_ERROR));
        }
    }

    @GetMapping(value = "courses", produces = "application/json")
    public String courseList(String studentId){
        List<Course> courseList = this.iPickService.getClassList(studentId);
        return this.gson.toJson(new ResponseBean<>(UniResponseEnums.SUCCESS, courseList));
    }

    @GetMapping(value = "courses/enable", produces = "application/json")
    public String selectList(String studentId){
        try {
            List<Course> courseList = this.iPickService.selectiveCourseList(studentId);
            return this.gson.toJson(new ResponseBean<>(UniResponseEnums.SUCCESS, courseList));
        }catch (Exception e){
            return this.gson.toJson(new ResponseBean<>(UniResponseEnums.ILLEGAL_REQUEST));
        }
    }
}
