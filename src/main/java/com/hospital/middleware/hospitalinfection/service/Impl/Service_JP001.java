package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.his.JP001DAO;
import com.hospital.middleware.hospitalinfection.service.IService;
import com.hospital.middleware.hospitalinfection.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class Service_JP001 extends BaseService implements IService {

    @Autowired
    private JP001DAO jp001;

    @Override
    public List<Map> queryData(Map paramMap) {
        List<Map> list =jp001.queryData(paramMap);
        for(int i = 0; i < list.size(); i++){
            Clob clob= (Clob) list.get(i).get("CourseContent");

            try {
                String text = clob.getSubString(1, (int) clob.length());
                list.get(i).put("CourseContent",text);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
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
