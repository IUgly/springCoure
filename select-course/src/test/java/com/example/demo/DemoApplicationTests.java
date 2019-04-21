package com.example.demo;

import com.example.demo.dao.Dao;
import com.example.demo.enums.Singleton;
import com.example.demo.service.IPickService;
import com.example.demo.service.IReptileService;
import com.example.demo.service.Imp.ReptileServiceImp;
import com.example.demo.vo.Record;
import com.google.gson.Gson;
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
    private IPickService iPickService;
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

    /**
     * 爬取课表
     */
    @Test
    public void transactionTest(){
        //2018215200
        IntStream.range(2017210001, 2017212200)
                .forEach(i -> this.iReptileService.reptileTask(String.valueOf(i)));
    }

    @Test
    public void courseList(){
        String sId = "2018211903";
        Gson gson = Singleton.INSTANCE.getGson();
        System.out.println(gson.toJson(this.iPickService.getClassList(sId)));
    }

    @Test
    public void enableList(){
        String studentId = "2018211903";
        System.out.println(Singleton.INSTANCE.getGson().toJson
                (this.iPickService.selectiveCourseList(studentId)));
    }

    @Test
    public void addCourse(){
        String sId = "2018211903";
        String cId = "";
        this.iPickService.addRecord(new Record(cId, sId));
    }

}
