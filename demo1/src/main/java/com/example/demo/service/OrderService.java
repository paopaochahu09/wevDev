package com.example.demo.service;

import com.example.demo.bean.DataStat;
import com.example.demo.mapper.OrderMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

import com.example.demo.bean.Good;
import com.example.demo.bean.Order;

@Service
public class OrderService {
    @Autowired
    public OrderMapper orderMapper;

    //传入订单信息，添加到订单;
    //***注意下单时间是时间戳的毫秒表示
    public void addOrder(Order x){
        //Order x=new Order();
        //随机生成12位的订单ID
        String orderID=getRandomString(12);
        x.setOrderID(orderID);
        /*
        x.setAccount(account);
        x.setName(name);
        x.setPrice(price);
        x.setPicture(picture);
        x.setOrderTime(orderTime);
        x.setIsDeal(0);
         */
        orderMapper.addOrder(x);
    }

    //传入订单orderID,删除对应的订单
    public void deleteOrder(String orderID){
         orderMapper.deleteOrder(orderID);
    }

    //传入orderID,将订单状态修改为已处理
    public void dealOrder(String orderID){
         orderMapper.dealOrder(orderID);
    }

    //length用户要求产生字符串的长度
    public String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer x=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            x.append(str.charAt(number));
        }
        return x.toString();
    }

    //传入account,获取订单信息
    public List<Order> getUserOrder(String account){
        return orderMapper.getUserOrder(account);
    }

    //获取全部的订单信息
    public List<Order> getAllOrders(){
        return orderMapper.getAllOrders();
    }

    //按照商品分组获得全部订单信息
    public List<DataStat> getAllOrdersGroup(){return orderMapper.getAllOrdersGroup();}
}
/*
    //支付购物车的商品，生成订单，并发送信息到用户的邮箱
    @Insert("insert into order values(#{orderID},#{account},#{name},#{price},#{picture},#{orderTime},#{isDeal})")
    public int addOrder(Order order);

    //管理员删除订单信息
    @Delete("delete from order where orderID=#{orderID}")
    public int deleteOrder(@Param("orderID") String orderID);

    //设置对应的订单为已处理,0代表未处理，1代表已处理
    @Update("update order set isDeal=1 where orderID=#{orderID}")
    public int dealOrder(@Param("orderID")String orderID);
*/