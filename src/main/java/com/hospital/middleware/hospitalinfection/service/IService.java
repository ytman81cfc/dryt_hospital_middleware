package com.hospital.middleware.hospitalinfection.service;

import java.util.List;
import java.util.Map;

public interface IService {
    public List<Map> queryData(Map paramMap);
    public String process(Map paramMap);
    public String assembleXml(List<String> paramList);
}
