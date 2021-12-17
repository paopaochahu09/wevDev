package com.example.demo.controller;

import com.example.demo.bean.DataStat;
import com.example.demo.bean.Good;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.bean.User;
import com.example.demo.bean.Order;
import java.util.List;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService order;

    //传入订单对象，新增加订单信息，其中订单ID可以在后端生成，但是前端可以传一个空值
    @ResponseBody
    @PostMapping("/addorder")
    public void addOrder(@RequestBody Order x){
        /*
        int num=order.addOrder(x);
        int errCode=0;
        String errMsg="";
        Map<String,Object> map=new HashMap<String,Object>();
        if(num>0){
            errCode=1;
            errMsg="添加新的订单信息成功！";
        }
        else{
            errMsg="添加新的订单信息失败，请重新尝试！";
        }
        map.put("errCode",errCode);
        map.put("errMsg",errMsg);
        return map;

         */
        order.addOrder(x);
    }

    //传入orderID，删除对应的订单信息
    @PostMapping("/deleteorder")
    public void deleteOrder(@RequestParam("orderID")String orderID){
        order.deleteOrder(orderID);
    }

    //传入订单ID，修改订单的处理状态
    @PostMapping("/dealorder")
    public void dealOrder(@RequestBody Order x){
        System.out.println("正在处理订单！"+x.getOrderID());
        order.dealOrder(x.getOrderID());
    }

    //传入用户的account，获取用户的订单信息
    @ResponseBody
    @GetMapping("/getuserorder")
    public Map<String,Object> getUserOrder(@RequestParam("account")String account){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Order> x=order.getUserOrder(account);
        map.put("data",x);
        System.out.println("获取了用户的订单信息，account："+account);
        return map;
    }

    //获取全部的订单信息
    @ResponseBody
    @GetMapping("/getallorders")
    public Map<String,Object> getAllOrders(){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Order> x=order.getAllOrders();
        map.put("data",x);
        System.out.println("getAllOrders");
        return map;
    }

    //测试专用
    @ResponseBody
    @GetMapping("/test")
    public Map<String,Object> test(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("errCode",0);
        map.put("errMsg","获取成功");
        return map;
    }

    //统计报表信息
    @ResponseBody
    @GetMapping("/getstat")
    public Map<String ,Object> getStat(){
        List<DataStat> x= order.getAllOrdersGroup();
        System.out.println("-------------");
        System.out.println(x.size());
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",x);
        return map;
    }
}
