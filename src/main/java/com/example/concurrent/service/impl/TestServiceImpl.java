package com.example.concurrent.service.impl;

import com.example.concurrent.dao.TestDao;
import com.example.concurrent.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
    /*@Autowired
    private TestDao testDao;

    @Override
    public List<Map> listAll() {
        return testDao.listAll();
    }*/
}
