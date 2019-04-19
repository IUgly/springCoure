package com.example.demo.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kuangjunlin
 */
@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(length = 20)
    private String xh;
    @Column(length = 60)
    private String xm;
    @Column(length = 10)
    private String xb;
    @Column(length = 16)
    private String bj;
    @Column(length = 50)
    private String zym;
    @Column(length = 50)
    private String yxm;
    @Column(length = 50)
    private String nj;
    @Column(length = 30)
    private String csrq;
    @Column(length = 50)
    private String xjzt;
    @Column(length = 50)
    private String mz;

    public Student() {
        this.xh = "201721190";
        this.xm = "匡俊霖";
        this.xb = "男";
        this.bj = "04031702";
        this.zym = "网络工程";
        this.yxm = "计算机科学与技术";
        this.nj = "2017";
        this.csrq = "199809289";
        this.xjzt = "what";
        this.mz = "汉";
    }

    public Student(String xh, String xm, String xb, String bj, String zym, String yxm, String nj, String csrq, String xjzt, String mz) {

    }

    @Override
    public String toString() {
        return "Student{" +
                "xh='" + xh + '\'' +
                ", xm='" + xm + '\'' +
                ", xb='" + xb + '\'' +
                ", bj='" + bj + '\'' +
                ", zym='" + zym + '\'' +
                ", yxm='" + yxm + '\'' +
                ", nj='" + nj + '\'' +
                ", csrq='" + csrq + '\'' +
                ", xjzt='" + xjzt + '\'' +
                ", mz='" + mz + '\'' +
                '}';
    }
}
