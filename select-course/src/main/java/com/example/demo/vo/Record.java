package com.example.demo.vo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author kuangjunlin
 */
@Data
@Entity
@Table(name = "record")
public class Record implements Serializable {
    @Id
    @Column(nullable = false, name = "c_id")
    private String cId;
    @Id
    @Column(nullable = false, name = "s_id")
    private String sId;
    @Column(precision = 5, scale = 2, columnDefinition = "bigint default 0")
    private double grade;
    public Record() {
    }

    public Record(String cId, String sId) {
        this.cId = cId;
        this.sId = sId;
    }
}
