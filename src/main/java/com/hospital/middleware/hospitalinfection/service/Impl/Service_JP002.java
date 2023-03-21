package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.his.JP002DAO;
import com.hospital.middleware.hospitalinfection.service.IService;
import com.hospital.middleware.hospitalinfection.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Service_JP002 extends BaseService implements IService {
    @Autowired
    private JP002DAO jp002;

    @Override
    public List<Map> queryData(Map paramMap) {
        return jp002.queryData(paramMap);
    }

    @Override
    public String assembleXml(List<String> paramList){
        String result = "<Response>";
        for(int i = 0; i < paramList.size(); i++){
            result = result + "<Clinic>" + paramList.get(i)+"</Clinic>";
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
