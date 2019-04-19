package com.example.demo.service;

/**
 * @author kuangjunlin
 */

public interface IReptileService {
    /**
     * 爬取该学生所选的必修课程，并存库
     * @param studentId 学号
     */
    void reptileCourseById(String studentId);

    /**
     * 爬取学生信息，存库
     * @param studentId 学号
     */
    void reptileStudentById(String studentId);

    /**
     * 执行爬虫任务
     * 爬取学生信息，再存入该学生的课表
     * @param studentId 学号
     */
    void reptileTask(String studentId);

}
