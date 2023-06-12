package com.hospital.middleware.emr.controller;

import com.hospital.middleware.emr.dao.his.EmrDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/emr")
public class EmrController {
    private Logger log = LoggerFactory.getLogger(EmrController.class);

    @Autowired
    private EmrDAO emrDAO;

    @RequestMapping("/queryData")
    public List<Map> queryData(@RequestParam Map<String, String> map){
        String orgCode = "H37068300546";
        String dataType = map.get("dataType");
        String startDate = map.get("startDate") + " 00:00:00";
        String endDate = map.get("endDate") + " 23:59:59";
        Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("orgCode", orgCode);
        paraMap.put("startDate", startDate);
        paraMap.put("endDate", endDate);

        List<Map> result = new ArrayList<Map>();
        if("baza".equals(dataType)){
            result = emrDAO.queryBaza(paraMap);
            return convertResult(result);
        }
        if("baf1".equals(dataType)){
            result = emrDAO.queryBaf1(paraMap);
            return convertResult(result);
        }
        if("baf4".equals(dataType)){
            result = emrDAO.queryBaf4(paraMap);
            return convertResult(result);
        }
        if("baf6".equals(dataType)){
            result = emrDAO.queryBaf6(paraMap);
            return convertResult(result);
        }
        return result;
    }

    public List<Map> convertResult(List<Map> data){
        List<Map> result = new ArrayList<Map>();
        for(int i = 0; i < data.size(); i++){
            Map element = new HashMap();
            Map row = data.get(i);
            Iterator ki = row.keySet().iterator();
            while(ki.hasNext()){
                String key = ki.next().toString();
                if(!(key.toUpperCase().equals("ORGCODE") || key.toUpperCase().equals("INID") || key.toUpperCase().equals("CREATE_TIME"))){
                    Object object = row.get(key);
                    element.put(key.toLowerCase(), object);
                }
            }
            result.add(element);
        }
        return result;
    }
}
