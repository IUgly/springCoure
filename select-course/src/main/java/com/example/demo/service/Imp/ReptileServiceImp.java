package com.example.demo.service.Imp;

import com.example.demo.dao.Dao;
import com.example.demo.enums.Singleton;
import com.example.demo.service.IReptileService;
import com.example.demo.util.PatternCourseUtil;
import com.example.demo.vo.Course;
import com.example.demo.vo.Student;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * @author kuangjunlin
 */
@Service
@Aspect
public class ReptileServiceImp implements IReptileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReptileServiceImp.class);
    @Autowired
    private Dao dao;
    @Value("${jwzx.student.info.url}")
    private String studentSearchUrl;
    @Value("${jwzx.student.course.list.url}")
    private String courseListUrl;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Retryable(maxAttempts=12, backoff=@Backoff(delay=100, maxDelay=500))
    public void reptileTask(String studentId) {
        reptileStudentById(studentId);
        reptileCourseById(studentId);
    }

    @Override
    public void reptileCourseById(String studentId) {
        String url = courseListUrl +studentId;
        RestTemplate restTemplate = Singleton.INSTANCE.getRestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        List<Course> courseList = PatternCourseUtil.matchAllCourse(response);
        if (courseList.size() == 0){
            return;
        }

        courseList.forEach(course -> {
            this.dao.addCourse(course);
            if (course.getType().equals("必修")){
                this.dao.addPickCourse(studentId, course.getId());
            }
        });
        LOGGER.error("正在爬取"+ studentId);
    }

    @Override
    public void reptileStudentById(String studentId) {
        String url = studentSearchUrl+studentId;
        RestTemplate restTemplate = Singleton.INSTANCE.getRestTemplate();
        String response = restTemplate.getForObject(url,
                String.class);
        int minLength = 200;
        if (response == null || response.length() < minLength){
            return;
        }
        Gson gson = Singleton.INSTANCE.getGson();
        JsonElement jsonElement = gson.fromJson(response, JsonObject.class)
                .getAsJsonArray("returnData").get(0);
        Student student = gson.fromJson(jsonElement, Student.class);

        this.dao.addStudent(student);
    }
}
