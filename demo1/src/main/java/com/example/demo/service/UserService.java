package com.example.demo.service;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.bean.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    //查询用户输入的账号密码是否正确,返回状态码，1代表成功登录，0代表登录失败
    public int conclLogin(String account,String password){
        int status=1;
        User x=userMapper.conclLogin(account,password);
        if(x==null){
            status=0;
        }
        System.out.println(status);
        return status;
    }

    //增加新用户,返回0代表注册失败，否则代表注册成功
    public int addUser(User x){
        int i=1;

        x.setPicture("xxxx.png");
        x.setAddress("地球");
        System.out.println("account:"+ x.getAccount());
        System.out.println("name:"+ x.getName());
        System.out.println("password:"+ x.getPassword());
        System.out.println("pic:"+ x.getPicture());
        System.out.println("name:"+ x.getAddress());
        try{
            i=userMapper.addUser(x);
            System.out.println(i);

        }catch(Exception e){
            System.out.println("出错了！");
            e.printStackTrace();
            i=0;
        } finally {
        }
        return i;
    }

    //获取用户的信息
    public User getUser(String account){
        return userMapper.getUser(account);
    }

    //修改用户的信息
    public int updateUser(User user){
        /*
        User user=new User();
        user.setPassword(password);
        user.setName(name);
        user.setAccount(account);
        user.setPicture(picture);
         */
        return userMapper.updateUser(user);
    }


    /*
     *  //判断用户是否登录成功
     *     @Select("select * from user where account=#{account} and password=#{password}")
     *     public User conclLogin(@Param("account") String account_in,@Param("password") String password_in);
     *
     *     //设置account为主键，如果插入数据库成功则新建成功，否则是账户名重复
     *     @Insert("insert into user(name,account,password) values(#{name},#{account},#{password}")
     *     public int addUser(User user);
     *
     *     //通过账户存储在cookie中的account获取用户信息
     *     @Select("select * from user where account=#{account}")
     *     public User getUser(@Param("account") String account_in);
     *
     *     //修改用户信息，每次必须传入全部字段，除了account之外的字段可以传入原来值代表未修改
     *     @Update("update user set name=#{name} ,password=#{password} ,picture=#{picture} where account=#{account}")
     *     public int updateUser(User user);
     */
}
