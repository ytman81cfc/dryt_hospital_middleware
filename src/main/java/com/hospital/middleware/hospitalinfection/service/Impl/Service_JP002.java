package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.JP002DAO;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Service_JP002 implements IService {
    @Autowired
    private JP002DAO jp002;

    @Override
    public List<Map> queryData(Map paramMap) {
        return jp002.queryData(paramMap);
    }
}
