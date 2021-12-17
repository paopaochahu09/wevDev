package com.example.demo.controller;

import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.example.demo.bean.Record;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordService recordService;

    //获取全部的浏览记录
    @ResponseBody
    @GetMapping("/getallrecords")
    public Map<String,Object> getAllRecords(){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Record> x=recordService.getAllRecords();
        map.put("data",x);
        return map;
    }

    //获取指定用户的浏览记录
    @ResponseBody
    @GetMapping("/getuserrecord")
    public Map<String,Object> getUserRecord(@RequestParam("account")String account){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Record> x=recordService.getUserRecord(account);
        map.put("data",x);
        return map;
    }

    //增加新的用户浏览记录
    @PostMapping("/addrecord")
    public void addRecord(@RequestBody Record record){
        recordService.addRecord(record);
    }
}
