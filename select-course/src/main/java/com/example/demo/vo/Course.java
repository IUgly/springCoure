package com.example.demo.vo;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.regex.Matcher;

/**
 * @author kuangjunlin
 */
@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(length = 100,name = "c_id")
    private final String id;
    @Column(length = 100)
    private final String course;
    @Column(length = 30)
    private final String classroom;
    @Column(length = 100)
    private final String teacher;
    @Column(length = 50)
    private final String type;
    @Column(length = 50)
    private final String sort;
    @Column(length = 100)
    private final String time;

    @Transient
    private String rawWeek,period,weekModel,
            weekBegin,weekEnd,lesson,day;
    @Transient
    private int[] week;
    @Transient
    private int peopleNum;

    public static class Builder{
        private final String id,course,classroom,teacher,type,sort,time;
        private String rawWeek,period,weekModel,weekBegin,weekEnd,lesson,day;
        private int[] week;

        public Builder(Course course){
            this.id = course.id;
            this.course = course.course;
            this.classroom = course.classroom;
            this.teacher = course.teacher;
            this.type = course.type;
            this.sort = course.sort;
            this.time = course.time;
        }

        public Builder day(String time){
            this.day = time.substring(0,3);
            this.lesson = time.substring(4,7);
            this.rawWeek = time.substring(8);
            return this;
        }

        public Course build(){
            return new Course(this);
        }

        public Builder(String id, String course, String classroom, String teacher, String type, String sort,String time) {
            this.id = id;
            this.course = course;
            this.classroom = classroom;
            this.teacher = teacher;
            this.type = type;
            this.sort = sort;
            this.time = time;
        }
        public Builder(Matcher matcher){
            this.sort = matcher.group(1);
            this.course = matcher.group(2);
            this.id = matcher.group(3);
            this.type = matcher.group(4);
            this.teacher = matcher.group(6);
            this.time = matcher.group(7);
            this.classroom = matcher.group(8);
        }

    }

    public Course(Builder builder){
        this.id = builder.id;
        this.course = builder.course;
        this.classroom = builder.classroom;
        this.teacher = builder.teacher;
        this.type = builder.type;
        this.sort = builder.sort;
        this.time = builder.time;
    }

    public Course(String id, String course, String classroom, String teacher, String type, String sort, String time) {
        this.id = id;
        this.course = course;
        this.classroom = classroom;
        this.teacher = teacher;
        this.type = type;
        this.sort = sort;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", course='" + course + '\'' +
                ", classroom='" + classroom + '\'' +
                ", teacher='" + teacher + '\'' +
                ", type='" + type + '\'' +
                ", sort='" + sort + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
