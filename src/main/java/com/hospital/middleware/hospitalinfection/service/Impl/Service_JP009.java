package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.JP009DAO;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class Service_JP009 implements IService {
    @Autowired
    private JP009DAO jp009;

    @Override
    public List<Map> queryData(Map paramMap) {
        return jp009.queryData(paramMap);
    }
}
