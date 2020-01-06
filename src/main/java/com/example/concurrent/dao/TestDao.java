package com.example.concurrent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestDao {
    // @Select("SELECT * FROM checkinfo")
    List<Map> listAll();
}
