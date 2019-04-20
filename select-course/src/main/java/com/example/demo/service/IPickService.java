package com.example.demo.service;

import com.example.demo.vo.Course;
import com.example.demo.vo.Record;

import java.util.List;
import java.util.Optional;

/**
 * @author kuangjunlin
 */
public interface IPickService {

    boolean addRecord(Record record);

    boolean deleteRecord(String sId, String cId);

    List<Course> getClassList(String sId);

    Optional<List<Course>> selectiveCourseList(String sId);
}
