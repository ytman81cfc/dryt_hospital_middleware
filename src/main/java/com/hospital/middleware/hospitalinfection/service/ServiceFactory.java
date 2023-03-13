package com.hospital.middleware.hospitalinfection.service;

import com.hospital.middleware.hospitalinfection.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListResourceBundle;
import java.util.Map;

@Service
public class ServiceFactory {
    @Autowired
    private Service_JP001 sjp001;
    @Autowired
    private Service_JP002 sjp002;
    @Autowired
    private Service_JP003 sjp003;
    @Autowired
    private Service_JP006 sjp006;
    @Autowired
    private Service_JP008 sjp008;
    @Autowired
    private Service_JP009 sjp009;
    @Autowired
    private Service_JD001 sjd001;
    @Autowired
    private Service_JD002 sjd002;

    public String getXMLData(Map paramMap){
       Map rootMap = (Map)paramMap.get("root");
       Map headMap = (Map)rootMap.get("sHead");
       Map infoMap = (Map)rootMap.get("sInfo");

       String sType = (String)headMap.get("sType");
       List<Map> result = null;
       if("JP001".equals(sType)){
           result = sjp001.queryData(infoMap);
       }
       if("JP002".equals(sType)){
            result = sjp002.queryData(infoMap);
       }
        if("JP003".equals(sType)){
            result = sjp003.queryData(infoMap);
        }
        if("JP006".equals(sType)){
            result = sjp006.queryData(infoMap);
        }
        if("JP008".equals(sType)){
            result = sjp008.queryData(infoMap);
        }
        if("JP009".equals(sType)){
            result = sjp009.queryData(infoMap);
        }
        if("JD001".equals(sType)){
            result = sjd001.queryData(infoMap);
        }
        if("JD002".equals(sType)){
            result = sjd002.queryData(infoMap);
        }
       return processResult(result);
    }

    String processResult(List<Map> result){
        return result.toString();
    }

}
