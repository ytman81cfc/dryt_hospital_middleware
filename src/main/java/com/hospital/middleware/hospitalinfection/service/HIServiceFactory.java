package com.hospital.middleware.hospitalinfection.service;

import com.hospital.middleware.hospitalinfection.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HIServiceFactory {
    @Autowired
    private Service_JP001 sjp001;
    @Autowired
    private Service_JP002 sjp002;
    @Autowired
    private Service_JP003 sjp003;
    @Autowired
    private Service_JP004 sjp004;
    @Autowired
    private Service_JP005 sjp005;
    @Autowired
    private Service_JP006 sjp006;
    @Autowired
    private Service_JP008 sjp008;
    @Autowired
    private Service_JP009 sjp009;
    @Autowired
    private Service_JP010 sjp010;
    @Autowired
    private Service_JP012 sjp012;
    @Autowired
    private Service_JP014 sjp014;
    @Autowired
    private Service_JP020 sjp020;
    @Autowired
    private Service_JP022 sjp022;
    @Autowired
    private Service_JP024 sjp024;
    @Autowired
    private Service_JD001 sjd001;
    @Autowired
    private Service_JD002 sjd002;
    @Autowired
    private Service_JD003 sjd003;
    @Autowired
    private Service_JD004 sjd004;


    public String getXMLData(Map paramMap) {
        Map rootMap = (Map) paramMap.get("root");
        Map headMap = (Map) rootMap.get("sHead");
        Object t_infoMap = rootMap.get("sInfo");
        if (t_infoMap instanceof String) {
            t_infoMap = new HashMap();
        }
        Map infoMap = (Map) t_infoMap;

        infoMap.put("OrgCode", "H37068300546");

        String sType = (String) headMap.get("sType");

        String result = "";
        if ("JP001".equals(sType)) {
            result = sjp001.process(infoMap);
        }
        if ("JP002".equals(sType)) {
            result = sjp002.process(infoMap);
        }
        if ("JP003".equals(sType)) {
            result = sjp003.process(infoMap);
        }
        if ("JP004".equals(sType)) {
            result = sjp004.process(infoMap);
        }
        if ("JP005".equals(sType)) {
            result = sjp005.process(infoMap);
        }
        if ("JP006".equals(sType)) {
            result = sjp006.process(infoMap);
        }
        if ("JP008".equals(sType)) {
            result = sjp008.process(infoMap);
        }
        if ("JP009".equals(sType)) {
            result = sjp009.process(infoMap);
        }
        if ("JP010".equals(sType)) {
            if (null==sjp010.process(infoMap)) {
                result="<Response></Response>";
            } else {
                result = sjp010.process(infoMap);
            }
        }
        if ("JP011".equals(sType)) {
            result = "<Response></Response>";
        }
        if ("JP012".equals(sType)) {
            if (null==sjp012.process(infoMap)) {
                result="<Response></Response>";
            } else {
                result = sjp012.process(infoMap);
            }
        }
        if ("JP013".equals(sType)) {
            result = "<Response></Response>";
        }
        if ("JP014".equals(sType)) {
            result = sjp014.process(infoMap);
        }
        if ("JP020".equals(sType)) {
            if (null==sjp020.process(infoMap)) {
                result="<Response></Response>";
            } else {
                result = sjp020.process(infoMap);
            }
        }
        if ("JP021".equals(sType)) {
            result = "<Response></Response>";
        }
        if ("JP022".equals(sType)) {
            if (null==sjp022.process(infoMap)) {
                result="<Response></Response>";
            } else {
                result = sjp022.process(infoMap);
            }
        }
        if ("JP023".equals(sType)) {
            result = "<Response></Response>";
        }
        if ("JP024".equals(sType)) {
            result = sjp024.process(infoMap);
        }
        if ("JD001".equals(sType)) {
            result = sjd001.process(infoMap);
        }
        if ("JD002".equals(sType)) {
            result = sjd002.process(infoMap);
        }
        if ("JD003".equals(sType)) {
            result = sjd003.process(infoMap);
        }
        if ("JD004".equals(sType)) {
            result = sjd004.process(infoMap);
        }

        return result;
    }
}