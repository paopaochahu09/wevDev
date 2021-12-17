package com.example.demo.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.bean.Record;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {
    //只有管理员能查看用户的浏览记录，可以提供几个功能，第一是查看全部的浏览记录，第二是查找指定用户的浏览记录（前端代实现）

    //查找全部的浏览记录
    @Select("select * from record")
    public List<Record> getAllRecords();

    //查找指定用户的浏览记录
    @Select("select * from record where account=#{account}")
    public List<Record> getUserRecord(@Param("account")String account);

    //传入record对象，增加新的浏览记录
    @Insert("insert into record(account,goodID,name,naviTime) values(#{record.account},#{record.goodID},#{record.name},#{record.naviTime})")
    public int addRecord(@Param("record") Record record);
}
