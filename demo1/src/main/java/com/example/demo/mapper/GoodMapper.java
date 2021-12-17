package com.example.demo.mapper;
import com.example.demo.bean.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;
import com.example.demo.bean.Shop;

@Mapper
public interface GoodMapper {
    //用于mainbody查询所有商品信息
    @Select("select * from good")
    public List<Good> getAllGoods();

    //增加新的商品信息，必须传入商品的全部字段
    @Insert("insert into good(goodID,name,price,picture,number,introduction) values(#{good.goodID},#{good.name},#{good.price},#{good.picture},#{good.number},#{good.introduction})")
    public int addGood(@Param("good") Good good);

    //修改商品信息，必须传入商品全部字段，但是goodID是固定不变的
    @Update("update good set name=#{good.name},price=#{good.price},picture=#{good.picture},number=#{good.number},introduction=#{good.introduction} where goodID=#{good.goodID}")
    public int updateGood(@Param("good") Good good);

    //删除商品信息
    //***注意同时删除shop表中关于该商品的信息
    @Delete("delete from good where goodID=#{goodID}")
    public int deleteGood(@Param("goodID") String goodID);

    //删除商品时顺便删除全购物车中关于该goodID的记录
    @Delete("delete from shop where goodID=#{goodID}")
    public int deleteShops(@Param("goodID")String goodID);

}
