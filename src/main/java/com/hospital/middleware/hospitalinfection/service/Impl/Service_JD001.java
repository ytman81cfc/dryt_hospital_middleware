package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.JD001DAO;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class Service_JD001 implements IService {
    @Autowired
    private JD001DAO JD001;

    @Override
    public List<Map> queryData(Map paramMap) {
        return JD001.queryData();
    }
}
