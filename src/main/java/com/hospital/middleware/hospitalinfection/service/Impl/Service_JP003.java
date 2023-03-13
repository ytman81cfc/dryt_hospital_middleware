package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.JP003DAO;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class Service_JP003 implements IService {
    @Autowired
    private JP003DAO jp003;

    @Override
    public List<Map> queryData(Map paramMap) {
        return jp003.queryData(paramMap);
    }
}
