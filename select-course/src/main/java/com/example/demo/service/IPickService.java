package com.example.demo.service;

import com.example.demo.vo.Record;

/**
 * @author kuangjunlin
 */
public interface IPickService {

    boolean addRecord(Record record);

    boolean deleteRecord(String sId, String cId);
}
