package com.example.demo.vo;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String college;
    private String id;
    private String password;

    public Student(String name, String college, String student_id, String password) {
        this.name = name;
        this.college = college;
        this.id = student_id;
        this.password = password;
    }

    public Student() {
    }

}
