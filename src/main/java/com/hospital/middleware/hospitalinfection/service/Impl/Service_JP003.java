package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.his.JP003DAO;
import com.hospital.middleware.hospitalinfection.service.IService;
import com.hospital.middleware.hospitalinfection.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class Service_JP003 extends BaseService implements IService {
    @Autowired
    private JP003DAO jp003;

    @Override
    public List<Map> queryData(Map paramMap) {
        return jp003.queryData(paramMap);
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
