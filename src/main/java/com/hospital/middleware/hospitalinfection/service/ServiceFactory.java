package com.hospital.middleware.hospitalinfection.service;

import com.hospital.middleware.hospitalinfection.service.Impl.Service_JP001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServiceFactory {
    @Autowired
    private Service_JP001 sjp001;

    public String getXMLData(Map paramMap){
       Map rootMap = (Map)paramMap.get("root");
       Map headMap = (Map)rootMap.get("sHead");
       Map infoMap = (Map)rootMap.get("sInfo");

       String sType = (String)headMap.get("sType");
       Map result = null;
       if("JP001".equals(sType)){
           result = sjp001.queryData(infoMap);
       }
       return processResult(result);
    }

    String processResult(Map result){
        return result.toString();
    }

}
