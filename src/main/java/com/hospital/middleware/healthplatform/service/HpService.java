package com.hospital.middleware.healthplatform.service;

import com.google.gson.Gson;
import com.hospital.middleware.healthplatform.dao.his.HealthplatfromDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HpService {
    @Autowired
    private HealthplatfromDAO hpfDAO;

    public String queryData(String startdt, String enddt, String dataType){
        String orgCode = "H37068300546";
        Gson gson = new Gson();
        String result = "";
        if("JB_CLML".equals(dataType.toUpperCase())){
            List<Map> queryResult = hpfDAO.queryJb_clml(orgCode);
            result = gson.toJson(queryResult);
        }

        return result;
    }
}