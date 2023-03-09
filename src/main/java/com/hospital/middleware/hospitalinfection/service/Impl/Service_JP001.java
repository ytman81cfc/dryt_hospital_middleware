package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.JP001DAO;
import com.hospital.middleware.hospitalinfection.service.IService;
import com.hospital.middleware.rationaldruguse.dao.TestOracleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Service_JP001 implements IService {

    @Autowired
    private JP001DAO jp001;

    @Override
    public Map queryData(Map paramMap) {
        return jp001.queryData();
    }
}
