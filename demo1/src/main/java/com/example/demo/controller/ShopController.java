package com.example.demo.controller;

import com.example.demo.service.OrderService;
import com.example.demo.service.ShopService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.bean.User;
import com.example.demo.bean.Order;
import com.example.demo.bean.Good;
import com.example.demo.bean.Shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    ShopService shop;

    //传入goodID和account，增加用户的购物车
    @ResponseBody
    @PostMapping("/addshop")
    public void addShop(@RequestBody Shop x){
        /*
        int num=shop.addShop(x);
        int errCode=0;
        String errMsg="";
        Map<String,Object> map=new HashMap<String,Object>();
        if(num>0){
            errCode=1;
            errMsg="添加商品到购物车成功！";
        }
        else{
            errMsg="添加商品到购物车失败，请重新尝试！";
        }
        map.put("errCode",errCode);
        map.put("errMsg",errMsg);
        return map;

         */
        shop.addShop(x);
    }

    //传入用户的account,获取购物车的商品信息
    //获取全部商品信息展示在mainboduu页面
    @ResponseBody
    @GetMapping("/getshop")
    Map<String,Object> getShop(@RequestParam("account")String account){
        List<Good> x=shop.getShop(account);
        System.out.println("查询的account："+account);
        System.out.println("查询到的数据"+ x.get(0).getGoodID());
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",x);
        return map;
    }

    //传入account和orderID,删除对应的购物车信息
    @PostMapping("/deleteshop")
    public void deleteshop(@RequestBody Shop x){
        shop.deleteShop(x.getAccount(),x.getGoodID());
    }
}
