package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.his.InidDAO;
import com.hospital.middleware.hospitalinfection.dao.lis.JD004DAO;
import com.hospital.middleware.hospitalinfection.dao.lis.JP012DAO;
import com.hospital.middleware.hospitalinfection.service.BaseService;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Service_JP012 extends BaseService implements IService {

    @Autowired
    private JP012DAO jp012;
    @Autowired
    private InidDAO inidDAO;
    @Override
    public List<Map> queryData(Map paramMap) {
        Map map = inidDAO.selectInid(paramMap);
        String EndDate= (String) paramMap.get("EndDate");
        String StartDate= (String) paramMap.get("StartDate");
        String ZYID= (String) map.get("IN_ID");
        String VisitId=  map.get("INTIMES").toString();
        String inhosno= (String) map.get("INHOSNO");
        String orgcode= (String) paramMap.get("OrgCode");
            List<Map> listMap=jp012.queryData(orgcode,inhosno,StartDate,EndDate);
            for (int j = 0; j < listMap.size(); j++){
                listMap.get(j).put("ZYID",ZYID);
                listMap.get(j).put("VisitId",Integer.parseInt(VisitId));
            }
        return listMap;
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
