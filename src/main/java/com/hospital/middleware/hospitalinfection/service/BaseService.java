package com.hospital.middleware.hospitalinfection.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseService {
    protected List<String> assembleXmlRowArray(List<Map> paraList){
        List<String> result = new ArrayList<String>();

        for(int i = 0; i < paraList.size(); i++){
            Map rowMap = paraList.get(i);
            String rowString = "";
            Iterator keyIterator = rowMap.keySet().iterator();
            while(keyIterator.hasNext()){
                String key = (String)keyIterator.next();
                Object valueObject = rowMap.get(key);
                String value = "";
                if(valueObject != null){
                    value = valueObject.toString();
                }
                rowString = rowString + "<" + key + ">" + value + "</" + key + ">";
            }
            result.add(rowString);
        }
        return result;
    }
}
