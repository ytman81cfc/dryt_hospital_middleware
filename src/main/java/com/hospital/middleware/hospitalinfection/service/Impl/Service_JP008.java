package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.JP008DAO;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Service_JP008 implements IService {
    @Autowired
    private JP008DAO jp008;

    @Override
    public List<Map> queryData(Map paramMap) {
        return jp008.queryData(paramMap);
    }
}
