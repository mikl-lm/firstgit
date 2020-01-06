package com.example.concurrent.service;

import com.example.concurrent.config.DataSources;
import com.example.concurrent.annotation.RoutingDataSource;
import com.example.concurrent.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DataSourceRoutingService {

    @Resource
    private TestDao testDao;

    @RoutingDataSource(DataSources.MASTER_DB) // 这个注解这时是可以省略，因为默认就是访问主库
    public List<Map> listAll1() {
        return testDao.listAll();
    }

    @RoutingDataSource(DataSources.SLAVE_DB)
    public List<Map> listAll2() {
        return testDao.listAll();
    }
}

