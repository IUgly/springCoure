package com.example.demo;

import com.example.demo.dao.Dao;
import com.example.demo.dao.StudentDao;
import com.example.demo.vo.Record;
import com.example.demo.vo.Student;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private Dao dao;
    @Test
    public void tableSizeTest(){
        System.out.println(this.dao.tableSize("record"));;
    }

    @Test
    public void addUser(){
        Student student = new Student(
                "kk",
                "jsj",
                "2017211903",
                "123");
        System.out.println(this.studentDao.addStudent(student));
    }

    @Test
    public void addReturnKey(){

        Record record = new Record("打扫课桌","2019-03-03","时长补录",
                "团体", "已生效", "2017211903",2.1);
        this.dao.insertUserAndReturnId(record);
        System.out.println(record.getId());
    }

    @Test
    public void deleteUser(){
        System.out.println(this.dao.deleteStudent("2017211903"));
    }

    @Test
    public void update(){
        Student student = new Student(
                "hh",
                "jsj",
                "123",
                "1231");
        System.out.println(this.dao.updateUserName(student));
    }

    @Test
    public void userList() {
        List<Student> studentList = this.dao.selectStudents();
        System.out.println(new Gson().toJson(studentList));
    }

    @Test
    public void tableSize(){
        Integer size = this.dao.tableSize("record");
        System.out.println(size);
    }

    @Test
    public void selectJSON(){
        List<Record> records = this.dao.selectInvitedRecordList("2017211903");
        System.out.println(records.toString());
    }

}
