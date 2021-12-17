package com.example.demo.mapper;

import com.example.demo.bean.DataStat;
import org.apache.ibatis.annotations.*;
import com.example.demo.bean.Order;
import com.example.demo.bean.Good;
import com.example.demo.bean.User;
import java.util.List;

@Mapper
public interface OrderMapper {
    //支付购物车的商品，生成订单，并发送信息到用户的邮箱
    @Insert("insert into orders(orderID,account,name,price,picture,orderTime,isDeal) values(#{order.orderID},#{order.account},#{order.name},#{order.price},#{order.picture},#{order.orderTime},#{order.isDeal})")
    public int addOrder(@Param("order") Order order);

    //管理员删除订单信息
    @Delete("delete from orders where orderID=#{orderID}")
    public int deleteOrder(@Param("orderID") String orderID);

    //设置对应的订单为已处理,0代表未处理，1代表已处理
    @Update("update orders set isDeal=1 where orderID=#{orderID}")
    public int dealOrder(@Param("orderID")String orderID);

    //传入用户的account，获取用户的订单信息
    @Select("select * from orders where account=#{account}")
    public List<Order> getUserOrder(@Param("account")String account);

    //获取全部的订单信息
    @Select("select * from orders")
    public List<Order> getAllOrders();

    //按照商品分组获得全部的订单信息,暂时用商品名字分组
    @Select("select name,sum(price) from orders group by name")
    public List<DataStat> getAllOrdersGroup();
}
