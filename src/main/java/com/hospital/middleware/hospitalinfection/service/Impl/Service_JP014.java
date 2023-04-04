package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.his.JP006DAO;
import com.hospital.middleware.hospitalinfection.dao.his.JP014DAO;
import com.hospital.middleware.hospitalinfection.service.BaseService;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Service_JP014 extends BaseService implements IService {
    @Autowired
    private JP014DAO jp014;

    @Override
    public List<Map> queryData(Map paramMap) {
        return jp014.queryData(paramMap);
    }

    @Override
    public String assembleXml(List<String> paramList){
        String result = "<Response>";
        for(int i = 0; i < paramList.size(); i++){
            result = result + "<List>" + paramList.get(i)+"</List>";
        }
        result = result + "</Response>";
        return result;
    }

    @Override
    public String process(Map paramMap){
        List<Map> t_result = queryData(paramMap);
        List<String> rowList = assembleXmlRowArray(t_result);
        String xmlString = assembleXml(rowList);
        return xmlString;
    }
}
