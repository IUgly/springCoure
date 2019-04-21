package com.example.demo.service.Imp;

import com.example.demo.dao.Dao;
import com.example.demo.service.IPickService;
import com.example.demo.vo.Course;
import com.example.demo.vo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author kuangjunlin
 */
@Service
public class PickServiceImp implements IPickService {
    @Autowired
    private Dao dao;
    @Override
    public boolean addRecord(Record record) {
        return this.dao.addPickCourse(record.getSId(), record.getCId());
    }

    @Override
    public boolean deleteRecord(String sId, String cId) {
        return this.dao.deleteRecord(sId, cId);
    }

    @Override
    public List<Course> getClassList(String sId) {
        return this.dao.selectCoursesBySId(sId);
    }

    @Override
    public List<Course> selectiveCourseList(String sId) {
        return this.dao.selectCoursesByType(sId, "选修");
    }
}
