package com.hospital.middleware.rationaldruguse.controller;

import com.hospital.middleware.rationaldruguse.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rationaldruguse/testhttp")
public class TestHttp {

    @Autowired
    private TestOracleDAO testOracleDAO;

    @Autowired
    private MsDrugInfoDAO msDrugInfoDAO;

    @Autowired
    private Dept_infoDAO dept_infoDAO;

    @Autowired
    private MsDeptWardDAO msDeptWardDAO;

    @Autowired
    private Doctor_infoDAO doctor_infoDAO;

    @Autowired
    private MsPatInfo_mzDAO msPatInfo_mzDAO;

    @Autowired
    private MsSyInfo_mzDAO msSyInfo_mzDAO;

    @Autowired
    private MsDiagInfo_mzDAO msDiagInfo_mzDAO;

    @Autowired
    private MsPresInfo_mzDAO msPresInfo_mzDAO;

    @Autowired
    private MsPatInfo_zyDAO msPatInfo_zyDAO;

    @Autowired
    private MsSyInfo_zyDAO MsSyInfo_zyDAO;

    @Autowired
    private MsDiagInfo_zyDAO msDiagInfo_zyDAO;

    @Autowired
    private MsPresInfo_zyDAO msPresInfo_zyDAO;

    @Autowired
    private MsTemperatureInfo_zyDAO msTemperatureInfo_zyDAO;

    @Autowired
    private MsRecordInfo_zyDAO msRecordInfo_zyDAO;

    @RequestMapping("testHttp01")
    public String testHttp01(){
        return "testHttp01";
    }


    @RequestMapping("msDrugInfo")
    public List<Map> queryMsDrugInfo(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msDrugInfo");
        map.put("Hoscode","H37068300546");
        return msDrugInfoDAO.queryMsDrugInfo(map);
    }

    @RequestMapping("dept_info")
    public List<Map> queryDept_info(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","dept_info");
        map.put("Hoscode","H37068300546");
        return dept_infoDAO.queryDept_info(map);
    }

    @RequestMapping("msDeptWard")
    public List<Map> queryMsDeptWard(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msDeptWard");
        map.put("Hoscode","H37068300546");
        return msDeptWardDAO.queryMsDeptWard(map);
    }

    @RequestMapping("doctor_info")
    public List<Map> queryDoctor_info(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","doctor_info");
        map.put("Hoscode","H37068300546");
        return doctor_infoDAO.queryDoctor_info(map);
    }

    @RequestMapping("msPatInfo_mz")
    public List<Map> queryMsPatInfo_mz(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msPatInfo_mz");
        map.put("Hoscode","H37068300546");
        map.put("beginDate","2023-03-15 00:00:00");
        map.put("endDate","2023-03-16 00:00:00");
        return msPatInfo_mzDAO.queryMsPatInfo_mz(map);
    }

    @RequestMapping("msSyInfo_mz")
    public List<Map> queryMsSyInfo_mz(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msSyInfo_mz");
        map.put("Hoscode","H37068300546");
        map.put("beginDate","2023-03-15 00:00:00");
        map.put("endDate","2023-03-16 00:00:00");
        return msSyInfo_mzDAO.queryMsSyInfo_mz(map);
    }

    @RequestMapping("msDiagInfo_mz")
    public List<Map> queryMsDiagInfo_mz(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msDiagInfo_mz");
        map.put("Hoscode","H37068300546");
        map.put("beginDate","2023-03-15 00:00:00");
        map.put("endDate","2023-03-16 00:00:00");
        return msDiagInfo_mzDAO.queryMsDiagInfo_mz(map);
    }

    @RequestMapping("msPresInfo_mz")
    public List<Map> queryMsPresInfo_mz(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msPresInfo_mz");
        map.put("Hoscode","H37068300546");
        map.put("beginDate","2023-03-15 00:00:00");
        map.put("endDate","2023-03-16 00:00:00");
        return msPresInfo_mzDAO.queryMsPresInfo_mz(map);
    }

    @RequestMapping("msPatInfo_zy")
    public List<Map> queryMsPatInfo_zy(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msPatInfo_zy");
        map.put("Hoscode","H37068300546");
        map.put("beginDate","2023-03-15 00:00:00");
        map.put("endDate","2023-03-16 00:00:00");
        return msPatInfo_zyDAO.queryMsPatInfo_zy(map);
    }

    @RequestMapping("msSyInfo_zy")
    public List<Map> queryMsSyInfo_zy(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msSyInfo_zy");
        map.put("Hoscode","H37068300546");
        map.put("beginDate","2023-03-15 00:00:00");
        map.put("endDate","2023-03-16 00:00:00");
        return MsSyInfo_zyDAO.queryMsSyInfo_zy(map);
    }

    @RequestMapping("msdiagInfo_zy")
    public List<Map> queryMsDiagInfo_zy(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msdiagInfo_zy");
        map.put("Hoscode","H37068300546");
        map.put("beginDate","2023-03-15 00:00:00");
        map.put("endDate","2023-03-16 00:00:00");
        return msDiagInfo_zyDAO.queryMsDiagInfo_zy(map);
    }

    @RequestMapping("msPresInfo_zy")
    public List<Map> queryMsPresInfo_zy(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msPresInfo_zy");
        map.put("Hoscode","H37068300546");
        map.put("beginDate","2023-03-15 00:00:00");
        map.put("endDate","2023-03-16 00:00:00");
        return msPresInfo_zyDAO.queryMsPresInfo_zy(map);
    }

    @RequestMapping("msTemperatureInfo_zy")
    public List<Map> queryMsTemperatureInfo_zy(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msTemperatureInfo_zy");
        map.put("Hoscode","H37068300546");
        return msTemperatureInfo_zyDAO.queryMsTemperatureInfo_zy(map);
    }

    @RequestMapping("msRecordInfo_zy")
    public List<Map> queryMsRecordInfo_zy(){
        Map<String,String> map =new HashMap<>();
        map.put("viewCode","msRecordInfo_zy");
        map.put("Hoscode","H37068300546");
        return msRecordInfo_zyDAO.queryMsRecordInfo_zy(map);
    }

    @RequestMapping("queryCurrentDateTime")
    public Map<Object, Object> queryCurrentDateTime(){
        return testOracleDAO.queryCurrentDateTime();
    }


}
