package com.example.demo.service;

import com.example.demo.bean.Good;
import com.example.demo.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class GoodService {
    @Autowired
    public GoodMapper goodMapper;

    //获取全部商品信息
    public List<Good> getAllGoods(){
        return goodMapper.getAllGoods();
    }

    //增加新的商品信息
    public void addGood(Good x){
        //随机生成goodID,长度为10
        /*
        x.setGoodID(goodID);
        x.setName(name);
        x.setIntroduction(introduction);
        x.setPicture(picture);
        x.setNumber(number);
        x.setPrice(price);
         */
        String goodID=getRandomString(10);
        System.out.println("goodID:"+goodID);
        x.setGoodID(goodID);
        System.out.println("商品的goodID"+x.getGoodID());
        goodMapper.addGood(x);
    }

    //修改商品信息
    public int updateGood(Good x){
        /*
        Good x=new Good();
        x.setGoodID(goodID);
        x.setName(name);
        x.setPrice(price);
        x.setPicture(picture);
        x.setNumber(number);
        x.setIntroduction(introduction);
         */
        return goodMapper.updateGood(x);
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

    //删除商品信息，同时删除全局购物车中关于该商品的信息
    public void deleteGood(String goodID){
        System.out.println("要删除的商品ID："+goodID);
        goodMapper.deleteShops(goodID);
        goodMapper.deleteGood(goodID);
    }
}

/*//用于mainbody查询所有商品信息
    @Select("select * from good")
    public List<Good> getAllGoods();

    //增加新的商品信息，必须传入商品的全部字段
    @Insert("insert into good(goodID,name,price,picture,number,introduction) values(#{goodID},#{name},#{price},#{picture},#{number},#{introduction})")
    public int addGood(Good good);

    //修改商品信息，必须传入商品全部字段，但是goodID是固定不变的
    @Update("update good set name=#{name},price=#{price},picture=#{picture},number=#{number},introduction=#{introduction} where goodID=#{goodID}")
    public int updateGood(Good good);

    //删除商品信息
    //***注意同时删除shop表中关于该商品的信息
    @Delete("delete from good where goodID=#{goodID}")
    public int deleteGood(@Param("goodID") String goodID);

    //删除商品时顺便删除全购物车中关于该goodID的记录
    @Delete("delete from shop where goodID=#{goodID}")
    public int deleteShops(@Param("goodID")String goodID);
 */
