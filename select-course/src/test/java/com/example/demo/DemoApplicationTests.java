package com.example.demo;

import com.example.demo.dao.Dao;
import com.example.demo.service.IReptileService;
import com.example.demo.service.Imp.ReptileServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class DemoApplicationTests {
    @Autowired
    private Dao dao;
    @Autowired
    private IReptileService iReptileService;
    @Autowired
    private ReptileServiceImp reptileServiceImp;
    @Test
    public void reptileCourse(){
        String studentId = "2017211903";
        this.iReptileService.reptileCourseById(studentId);
    }
    @Test
    public void reptileStudent(){
        String studentId = "2017211903";
        this.iReptileService.reptileStudentById(studentId);
    }
    @Test
    public void transactionTest(){
        //2018215200
        IntStream.range(2017210001, 2017212200)
                .forEach(i -> this.iReptileService.reptileTask(String.valueOf(i)));
    }
}
