package com.hospital.middleware.rationaldruguse.controller;

import com.google.gson.Gson;
import com.hospital.middleware.rationaldruguse.dao.his.*;
import com.hospital.middleware.rationaldruguse.dao.lis.MsLabInfo_zy_lisDAO;
import com.hospital.middleware.rationaldruguse.dao.lis.TestMySqlDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rational/druguse")
public class DrugUseController {

    private Logger log = LoggerFactory.getLogger(DrugUseController.class);

    @Autowired
    private TestMySqlDAO testMySqlDAO;

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

    @Autowired
    private MsLabInfo_zy_lisDAO msLabInfo_zy_lisDAO;

    @Autowired
    private MsLabInfo_zy_hisDAO msLabInfo_zy_hisDAO;

    @RequestMapping("/queryData")
    public List<Map> queryData(@RequestParam Map<String, String> map){
        log.info(map.toString());
        Gson gson = new Gson();
        String str = gson.toJson(map);
        log.info("合理用药传入参数:" + str);

        if("msDrugInfo".equals(map.get("viewCode"))){
            return msDrugInfoDAO.queryMsDrugInfo(map);
        }
        if("dept_info".equals(map.get("viewCode"))){
            return dept_infoDAO.queryDept_info(map);
        }
        if("msDeptWard".equals(map.get("viewCode"))){
            return msDeptWardDAO.queryMsDeptWard(map);
        }
        if("doctor_info".equals(map.get("viewCode"))){
            return doctor_infoDAO.queryDoctor_info(map);
        }
        if("msPatInfo_mz".equals(map.get("viewCode"))){
            return msPatInfo_mzDAO.queryMsPatInfo_mz(map);
        }
        if("msSyInfo_mz".equals(map.get("viewCode"))){
            return msSyInfo_mzDAO.queryMsSyInfo_mz(map);
        }
        if("msDiagInfo_mz".equals(map.get("viewCode"))){
            return msDiagInfo_mzDAO.queryMsDiagInfo_mz(map);
        }
        if("msPresInfo_mz".equals(map.get("viewCode"))){
            return msPresInfo_mzDAO.queryMsPresInfo_mz(map);
        }
        if("msPatInfo_zy".equals(map.get("viewCode"))){
            return msPatInfo_zyDAO.queryMsPatInfo_zy(map);
        }
        if("msSyInfo_zy".equals(map.get("viewCode"))){
            return MsSyInfo_zyDAO.queryMsSyInfo_zy(map);
        }
        if("msDiagInfo_zy".equals(map.get("viewCode"))){
            return msDiagInfo_zyDAO.queryMsDiagInfo_zy(map);
        }
        if("msPresInfo_zy".equals(map.get("viewCode"))){
            return msPresInfo_zyDAO.queryMsPresInfo_zy(map);
        }
        if("msTemperatureInfo_zy".equals(map.get("viewCode"))){
            return msTemperatureInfo_zyDAO.queryMsTemperatureInfo_zy(map);
        }
        if("msRecordInfo_zy".equals(map.get("viewCode"))){
            return msRecordInfo_zyDAO.queryMsRecordInfo_zy(map);
        }
        if ("msLabInfo_zy".equals(map.get("viewCode"))){
            List<Map> list = msLabInfo_zy_lisDAO.queryMsLabInfo_zy_lis(map);
            msLabInfo_zy_hisDAO.deleteAll(map);
            for (int i = 0; i < list.size(); i++) {
                msLabInfo_zy_hisDAO.add(list.get(i));
            }
            msLabInfo_zy_hisDAO.updateAll(map);
            List<Map> resultList = msLabInfo_zy_hisDAO.queryMsLabInfo_zy_his(map);
            return resultList;
        }
        if("msLabPatho_zy".equals(map.get("viewCode"))){
            List<Map> result = new ArrayList();
            return result;
        }
        if("msLabAnti_zy".equals(map.get("viewCode"))){
            List<Map> result = new ArrayList();
            return result;
        }


        return testMySqlDAO.queryCurrentDateTime();
    }
}