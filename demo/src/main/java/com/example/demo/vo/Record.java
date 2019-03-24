package com.example.demo.vo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class Record {
    private Integer id;
    private String content;
    private String start_time;
    private String title;
    private String add_way;
    private String status;
    private String student_id;
    private Double hours;
    private JSONArray jsonArray;

    public Record(String content, String start_time, String title, String add_way, String status, String student_id, Double hours) {
        this.content = content;
        this.start_time = start_time;
        this.title = title;
        this.add_way = add_way;
        this.status = status;
        this.student_id = student_id;
        this.hours = hours;
    }
}
