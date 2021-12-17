package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;
import com.example.demo.bean.User;

import java.util.List;

@Mapper
public interface UserMapper {
    //判断用户是否登录成功
    @Select("select * from user where account=#{account} and password=#{password}")
    public User conclLogin(@Param("account") String account_in,@Param("password") String password_in);

    //设置account为主键，如果插入数据库成功则新建成功，否则是账户名重复
    @Insert("insert into user(name,account,password) values(#{user.name},#{user.account},#{user.password})")
    public int addUser(@Param("user") User user);

    //通过账户存储在cookie中的account获取用户信息
    @Select("select * from user where account=#{account}")
    public User getUser(@Param("account") String account);

    //修改用户信息，每次必须传入全部字段，除了account之外的字段可以传入原来值代表未修改
    @Update("update user set name=#{user.name} ,password=#{user.password} ,picture=#{user.picture} ,address=#{user.address}where account=#{user.account}")
    public int updateUser(@Param("user") User user);
}
