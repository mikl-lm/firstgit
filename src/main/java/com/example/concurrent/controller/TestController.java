package com.example.concurrent.controller;

import com.example.concurrent.service.DataSourceRoutingService;
import com.example.concurrent.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
@Api(description = "生产者进程API接口")
@RestController
public class TestController {

    @Autowired
    private DataSourceRoutingService dataSourceRoutingService;

    @RequestMapping("/test")
    public List<Map> test () {
       // List<Map> list =  testService.listAll();
       return new ArrayList<>();
    }

    @ApiOperation(value="查询单词计数", notes="查询单词计数", produces="application/json")
    @ApiImplicitParam(name = "word", value = "单词", paramType = "query", required = false, dataType = "String")
    @RequestMapping("/test1")
    public List<Map> test1 () {
        log.info("--------------test1--------------");
        List<Map> list =  dataSourceRoutingService.listAll1();
        return list;
    }
    @RequestMapping("/test2")
    public List<Map> test2 () {
        List<Map> list =  dataSourceRoutingService.listAll2();
        return list;
    }
}
