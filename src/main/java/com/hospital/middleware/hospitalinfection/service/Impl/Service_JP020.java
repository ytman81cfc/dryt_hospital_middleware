package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.his.InidDAO;
import com.hospital.middleware.hospitalinfection.dao.lis.JP010DAO;
import com.hospital.middleware.hospitalinfection.dao.lis.JP012DAO;
import com.hospital.middleware.hospitalinfection.dao.lis.JP020DAO;
import com.hospital.middleware.hospitalinfection.service.BaseService;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Service_JP020 extends BaseService implements IService {

    @Autowired
    private JP020DAO jp020;
    @Autowired
    private InidDAO inidDAO;

    @Override
    public List<Map> queryData(Map paramMap) {
        Map map = inidDAO.selectRegid(paramMap);
        if(null==map) {
            return null;
        }else {
            String EndDate = (String) paramMap.get("EndDate");
            String StartDate = (String) paramMap.get("StartDate");
            String MZID = (String) map.get("IN_ID");
            String VisitId = map.get("NUM").toString();
            String inhosno = (String) map.get("INHOSNO");
            String orgcode = (String) paramMap.get("OrgCode");
            List<Map> listMap = jp020.queryData(orgcode, inhosno, StartDate, EndDate);
            for (int j = 0; j < listMap.size(); j++) {
                listMap.get(j).put("MZID", MZID);
                listMap.get(j).put("VisitId", Integer.parseInt(VisitId));
            }
            return listMap;
        }
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
        if(null==queryData(paramMap)){
            return null;
        }else {
            List<Map> t_result = queryData(paramMap);
            List<String> rowList = assembleXmlRowArray(t_result);
            String xmlString = assembleXml(rowList);
            return xmlString;
        }
    }
}
