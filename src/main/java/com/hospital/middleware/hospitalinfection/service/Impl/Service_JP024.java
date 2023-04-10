package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.his.JP024DAO;
import com.hospital.middleware.hospitalinfection.service.BaseService;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Service_JP024 extends BaseService implements IService {
    @Autowired
    private JP024DAO jp024;

    @Override
    public List<Map> queryData(Map paramMap) {
        List<Map> list = jp024.queryData(paramMap);
        List<Map> result = new ArrayList<>();
        String num = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).containsKey("WeightValues")) {
                num = list.get(i).get("WeightValues").toString();
                result.add(list.get(i));
            } else {
                list.get(i).put("WeightValues", num);
                result.add(list.get(i));
            }
        }
        return result;
    }

    @Override
    public String assembleXml(List<String> paramList) {
        String result = "<Response>";
        for (int i = 0; i < paramList.size(); i++) {
            result = result + "<List>" + paramList.get(i) + "</List>";
        }
        result = result + "</Response>";
        return result;
    }

    @Override
    public String process(Map paramMap) {
        List<Map> t_result = queryData(paramMap);
        List<String> rowList = assembleXmlRowArray(t_result);
        String xmlString = assembleXml(rowList);
        return xmlString;
    }
}
