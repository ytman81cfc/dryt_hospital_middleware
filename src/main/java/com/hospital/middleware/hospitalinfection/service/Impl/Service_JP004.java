package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.his.JP004DAO;
import com.hospital.middleware.hospitalinfection.service.BaseService;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Service_JP004 extends BaseService implements IService {
    @Autowired
    private JP004DAO jp004;

    @Override
    public List<Map> queryData(Map paramMap) {
        return jp004.queryData(paramMap);
    }

    @Override
    public String assembleXml(List<String> paramList){
        String result = "<Response><DiagnosisList>";
        for(int i = 0; i < paramList.size(); i++){
            result = result + "<Diagnosis>" + paramList.get(i)+"</Diagnosis>";
        }
        result = result + "</DiagnosisList></Response>";
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
