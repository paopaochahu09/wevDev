package com.example.demo.service;

import com.example.demo.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.ShopMapper;
import com.example.demo.bean.Good;
import com.example.demo.bean.Shop;
import java.util.List;

@Service
public class ShopService {
    @Autowired
    public ShopMapper shopMapper;

    //查找对应用户的购物车，返回List<Good>
    public List<Good> getShop(String account){
        return shopMapper.getShop(account);
    }

    //添加商品到购物车
    public void addShop(Shop x){
        /*
        Shop x=new Shop();
        x.setAccount(account);
        x.setGoodID(goodID);
         */
         shopMapper.addShop(x);
    }

    //删除购物车对应的商品
    public void deleteShop(String account,String orderID){
        Shop x=new Shop();
        x.setGoodID(orderID);
        x.setAccount(account);
        shopMapper.deleteshop(x);
    }
}
/*
    //查询该用户的全部购物车商品，使用联表查询
    @Select("select B from shop A,good B where A.account=#{account} and A.goodID=B.goodID")
    public List<Good> getShop(@Param("account") String account);

    //用户主动删除购物车的物品或者支付时删除对应的购物车物品,传入商品ID和account
    @Delete("delete from shop where account=#{account} and goodID=#{goodID}")
    public int deleteshop(Shop shop);

    //添加商品到购物车
    @Insert("insert into shop values(#{account},#{goodID})")
    public int addShop(Shop shop);
    //购物车没有修改选项
 */