package com.example.demo.service;

import com.example.demo.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.bean.Record;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    RecordMapper recordMapper;

    //获取全部的浏览记录
    public List<Record> getAllRecords(){
        return recordMapper.getAllRecords();
    }

    //获取指定用户的浏览记录
    public List<Record> getUserRecord(String account){
        return recordMapper.getUserRecord(account);
    }

    //增加用户新的浏览记录
    public void addRecord(Record record){
        recordMapper.addRecord(record);
    }
}
