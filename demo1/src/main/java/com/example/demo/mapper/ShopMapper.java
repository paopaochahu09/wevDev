package com.example.demo.mapper;

import com.example.demo.bean.Good;
import com.example.demo.bean.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopMapper {
    //查询该用户的全部购物车商品，使用联表查询
    @Select("select b.goodID,b.name,b.price,b.number,b.picture,b.introduction from shop as a,good as b  where a.account=#{account} AND a.goodID=b.goodID")
    public List<Good> getShop(@Param("account") String account);

    //用户主动删除购物车的物品或者支付时删除对应的购物车物品,传入商品ID和account
    @Delete("delete from shop where account=#{shop.account} and goodID=#{shop.goodID} limit 1")
    public int deleteshop(@Param("shop") Shop shop);

    //添加商品到购物车
    @Insert("insert into shop(account,goodID) values(#{shop.account},#{shop.goodID})")
    public int addShop(@Param(("shop")) Shop shop);
    //购物车没有修改选项
}
