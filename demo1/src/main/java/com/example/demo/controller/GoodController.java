package com.example.demo.controller;

import com.example.demo.service.GoodService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.bean.User;
import com.example.demo.bean.Good;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    GoodService good;

    //获取全部商品信息展示在mainboduu页面
    @ResponseBody
    @GetMapping("/getallgoods")
    Map<String,Object> getAllGoods(){
        List<Good> x=good.getAllGoods();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",x);
        return map;
    }

    //根据传入的数据新增加商品信息
    @ResponseBody
    @PostMapping("/addgood")
    public void addGood(@RequestBody Good x){
        /*
        int num=good.addGood(x);
        int errCode=0;
        String errMsg="";
        Map<String,Object> map=new HashMap<String,Object>();
        if(num>0){
            errCode=1;
            errMsg="添加新的商品信息成功！";
        }
        else{
            errMsg="添加新的商品信息失败，请重新尝试！";
        }
        map.put("errCode",errCode);
        map.put("errMsg",errMsg);
        return map;

         */
        good.addGood(x);
    }

    //传入good对象，修改对应的商品信息
    @ResponseBody
    @PostMapping("/updategood")
    public Map<String,Object> updateGood(@RequestBody Good x){
        int errCode=0;
        String errMsg="";
        Map<String,Object> map=new HashMap<String,Object>();
        int num=good.updateGood(x);
        if(num>0){
            errCode=1;
            errMsg="更新商品信息成功！";
        }
        else{
            errMsg="更新商品信息失败";
        }
        map.put("errCode",errCode);
        map.put("errMsg",errMsg);
        return map;
    }

    //删除商品信息，传入goodID
    @PostMapping("/deletegood")
    public void deletegood(@RequestBody Good temp){
        good.deleteGood(temp.getGoodID());
    }


}
