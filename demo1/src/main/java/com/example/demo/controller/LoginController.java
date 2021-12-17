package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.bean.User;
import com.example.demo.bean.Good;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
     UserService user;

    //用户登录时传递的账户密码
    @ResponseBody
    @PostMapping("/concllogin")
    public Map<String,Object> conclLogin(@RequestBody User x){
        String account=x.getAccount();
        String password=x.getPassword();
        int errCode=user.conclLogin(account,password);
        String errMsg="";
        Map<String,Object> map=new HashMap<String,Object>();
        if(errCode==0){
            errMsg="登录失败，请检查账号和密码是否输入正确!";
        }
        else{
            errMsg="登录成功，欢迎您！";
        }
        map.put("errCode",errCode);
        map.put("errMsg",errMsg);
        System.out.println("登录信息："+errMsg);
        return map;
    }

    //获取用户的信息，并存储在前端
    @ResponseBody
    @GetMapping("/getuser")
    public Map<String,Object> getUser(@RequestParam("account")String account){
        User x=user.getUser(account);
        System.out.println("address:"+x.getAddress());
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",x);
        return map;
    }

    //获取用户传来的信息，并更新到数据库
    @ResponseBody
    @PostMapping("/updateuser")
    public Map<String,Object> updateUser(@RequestBody User x){
        int errCode=0;
        String errMsg="";
        Map<String,Object> map=new HashMap<String,Object>();
        int num=user.updateUser(x);
        if(num>0){
            errCode=1;
            errMsg="更新信息成功！";
        }
        else{
            errMsg="更新信息失败";
        }
        map.put("errCode",errCode);
        map.put("errMsg",errMsg);
        System.out.println("updares:"+x.getAddress());
        return map;
    }

    //增加新用户，如果账号重复则返回错误，否则返回正确
    @ResponseBody
    @PostMapping("/adduser")
    public Map<String,Object> addUser(@RequestBody User x){
        int errCode=0;
        String errMsg="";
        System.out.println("来注册了："+x.getAccount());
        Map<String,Object> map=new HashMap<String,Object>();
        errCode=user.addUser(x);
        if(errCode==0){
            errMsg="该账号已注册，请重新注册新账号";
        }else{
            errMsg="注册成功！欢迎你，"+x.getName();
        }
        map.put("errCode",errCode);
        map.put("errMsg",errMsg);
        return map;
    }
}
