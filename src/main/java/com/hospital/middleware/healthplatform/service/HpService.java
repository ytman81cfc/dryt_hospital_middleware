package com.hospital.middleware.healthplatform.service;

import com.google.gson.Gson;
import com.hospital.middleware.healthplatform.dao.his.HealthplatfromDAO;
import com.hospital.middleware.healthplatform.dao.lis.Healthplatform_lisDAO;
import com.hospital.middleware.healthplatform.dao.yb.LzwjDao;
import com.hospital.middleware.rationaldruguse.controller.DrugUseController;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;
import java.util.zip.GZIPInputStream;

@Service
public class HpService {
    @Autowired
    private HealthplatfromDAO hpfDAO;
    @Autowired
    private Healthplatform_lisDAO hpf_lisDAO;
    @Autowired
    private LzwjDao ld;

    private Logger log = LoggerFactory.getLogger(HpService.class);

    public String queryData(String begtime, String endtime, String dataType) {
        boolean isTest = true;
        String orgCode = "H37068300546";
        Gson gson = new Gson();
        String result = "";
        begtime = begtime + " 00:00:00";
        endtime = endtime + " 23:59:59";

        Map<String, String> param = new HashMap<String, String>();
        param.put("begTime", begtime);
        param.put("endTime", endtime);

        try {
            //材料目录
            if ("JB_CLML".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJb_clml(orgCode);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteJB_CLML(param);
                    for (Map row : rows) {
                        ld.insertJB_CLML(row);
                    }
                }
            }
            //收费项目目录
            if ("JB_XMML".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJb_xmml(orgCode);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteJB_XMML(param);
                    for (Map row : rows) {
                        ld.insertJB_XMML(row);
                    }
                }
            }
            //病区信息
            if ("JBBQXXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJbbqxxb(orgCode);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteJBBQXXB(param);
                    for (Map row : rows) {
                        ld.insertJBBQXXB(row);
                    }
                }
            }
            //科室信息
            if ("JBKSXXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJbksxxb(orgCode);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteJBKSXXB(param);
                    for (Map row : rows) {
                        ld.insertJBKSXXB(row);
                    }
                }
            }
            //医护人员信息表
            if ("JBYHRYXXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJbyhryxxb(orgCode);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteJBYHRYXXB(param);
                    for (Map row : rows) {
                        ld.insertJBYHRYXXB(row);
                    }
                }
            }
            //疾病诊断目录, 目前对所有机构而言, 机构代码都是370600
            if ("JB_ZDML".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJb_zdml("370600");
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteJB_ZDML(param);
                    for (Map row : rows) {
                        ld.insertJB_ZDML(row);
                    }
                }
            }
            //手术目录, 目前对所有机构而言, 机构代码都是370600
            if ("JB_SSML".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJb_ssml("370600");
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteJB_SSML(param);
                    for (int i = 0; i < rows.size(); i++) {
                        ld.insertJB_SSML(rows.get(i));
                    }
                }
            }
            //药品基本信息
            if ("YP_JBXXK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryYp_jbxxk(orgCode);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteYP_JBXXK(param);
                    for (int i = 0; i < rows.size(); i++) {
                        ld.insertYP_JBXXK(rows.get(i));
                    }
                }
            }
            //患者基本信息表
            if ("JBBRJBXXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJbbrjbxxb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteJBBRJBXXB(param);
                    for (int i = 0; i < rows.size(); i++) {
                        ld.deleteJBBRJBXXBByPk(rows.get(i));
                        ld.insertJBBRJBXXB(rows.get(i));
                    }
                }
            }

            //门诊挂号表
            if ("MZGHB".equals(dataType.toUpperCase())) {
                List<Map> queryResult_gh = hpfDAO.queryMzghb(orgCode, begtime, endtime);
                List<Map> queryResult_th = hpfDAO.queryMzthb(orgCode, begtime, endtime);
                List<Map> queryResult = new ArrayList<Map>();
                queryResult.addAll(queryResult_gh);
                queryResult.addAll(queryResult_th);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteMZGHB(param);
                    for (int i = 0; i < rows.size(); i++) {
                        ld.insertMZGHB(rows.get(i));
                    }
                }
            }
            //门诊就诊记录表
            if ("MZJZJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryMzjzjlb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteMZJZJLB(param);
                    for (Map row : rows) {
                        ld.insertMZJZJLB(row);
                    }
                }
            }
            //门诊医嘱明细表
            if ("MZYZMXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryMzyzmxb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteMZYZMXB(param);
                    for (Map row : rows) {
                        ld.insertMZYZMXB(row);
                    }
                }
            }
            //门诊收费记录表
            if ("MZSFJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult_sf = hpfDAO.queryMzsfjlbsf(orgCode, begtime, endtime);
                List<Map> queryResult_tf = hpfDAO.queryMzsfjlbtf(orgCode, begtime, endtime);
                List<Map> queryResult = new ArrayList<Map>();
                queryResult.addAll(queryResult_sf);
                queryResult.addAll(queryResult_tf);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteMZSFJLB(param);
                    for (int i = 0; i < rows.size(); i++) {
                        ld.deleteMZSFJLBByPk(rows.get(i));
                        ld.insertMZSFJLB(rows.get(i));
                    }
                }
            }
            //门诊收费明细表
            if ("MZSFMXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult_sf = hpfDAO.queryMzsfmxbsf(orgCode, begtime, endtime);
                List<Map> queryResult_tf = hpfDAO.queryMzsfmxbtf(orgCode, begtime, endtime);
                List<Map> queryResult = new ArrayList<Map>();
                queryResult.addAll(queryResult_sf);
                queryResult.addAll(queryResult_tf);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteMZSFMXB(param);
                    for (Map row : rows) {
                        ld.insertMZSFMXB(row);
                    }
                }
            }
            //门诊费用结算信息
            if ("MZFYJSXX".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryMzfyjsxx(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteMZFYJSXX(param);
                    for (Map row : rows) {
                        ld.deleteMZFYJSXXByPk(row);
                        ld.insertMZFYJSXX(row);
                    }
                }
            }

            //住院就诊记录表
            if ("ZYJZJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyjzjlb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYJZJLB(param);
                    for (Map row : rows) {
                        ld.deleteZYJZJLBByPk(row);
                        ld.insertZYJZJLB(row);
                    }
                }
            }
            //住院医嘱明细表
            if ("ZYYZMXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyyzmxb(orgCode, begtime, endtime);


                //查询莱州卫健科室对应关系
                List<Map> DicDeptCompareList = hpfDAO.queryDicDeptCompare(orgCode);
                HashMap<String, Map> DicDeptCompareHM = new  HashMap<String, Map>();
                for(int a = 0; a < DicDeptCompareList.size(); a++){
                    DicDeptCompareHM.put(DicDeptCompareList.get(a).get("his_item_id").toString(), DicDeptCompareList.get(a));
                }

                //查询员工身份证号
                List<Map> DicDoctorCertNoList = hpfDAO.queryDicDoctorCertNo(orgCode);
                HashMap<String, Map> DicDoctorCertNoHM = new  HashMap<String, Map>();
                for(int a = 0; a < DicDoctorCertNoList.size(); a++){
                    DicDoctorCertNoHM.put(DicDoctorCertNoList.get(a).get("usercode").toString(), DicDoctorCertNoList.get(a));
                }

                //查询药品 院内药物剂型代码 院内药物剂型名称 中心药物剂型代码 中心药物剂型名称
                List<Map> DicDrugJxInforList = hpfDAO.queryDicDrugJxInfor(orgCode);
                HashMap<String, Map> DicDrugJxInforHM = new  HashMap<String, Map>();
                for(int a = 0; a < DicDrugJxInforList.size(); a++){
                    DicDrugJxInforHM.put(DicDrugJxInforList.get(a).get("drugcode").toString(), DicDrugJxInforList.get(a));
                }

                //查询药品 中心用药频度代码 中心用药频度名称
                List<Map> DicDrugPdInforList = hpfDAO.queryDicDrugPdInfor(orgCode);
                HashMap<String, Map> DicDrugPdInforHM = new  HashMap<String, Map>();
                for(int a = 0; a < DicDrugPdInforList.size(); a++){
                    DicDrugPdInforHM.put(DicDrugPdInforList.get(a).get("his_item_id").toString(), DicDrugPdInforList.get(a));
                }

                //查询药品 中心药品用法代码 中心药品用法名称
                List<Map> DicDrugYfInforList = hpfDAO.queryDicDrugYfInfor(orgCode);
                HashMap<String, Map> DicDrugYfInforHM = new  HashMap<String, Map>();
                for(int a = 0; a < DicDrugYfInforList.size(); a++){
                    DicDrugYfInforHM.put(DicDrugYfInforList.get(a).get("his_item_id").toString(), DicDrugYfInforList.get(a));
                }


                for (int i = 0; i < queryResult.size(); i++) {
                    Map row = queryResult.get(i);
                    row.put("YLJGDM", "12370683MB2637101K");

                    //处理莱州卫健科室对应关系
                    Object YNXDKSBM = row.get("YNXDKSBM");
                    if(YNXDKSBM != null){
                        if(DicDeptCompareHM.containsKey(YNXDKSBM.toString())){
                            Map ddc = DicDeptCompareHM.get(YNXDKSBM.toString());
                            String item_id = ddc.get("item_id").toString();
                            String item_name = ddc.get("item_name").toString();
                            row.put("XDKSBM", item_id);
                            row.put("XDKSMC", item_name);
                        }else{
                            row.put("XDKSBM", "-");
                            row.put("XDKSMC", "-");
                        }
                    }

                    //处理员工身份证号
                    Object XDRGH = row.get("XDRGH");
                    if(XDRGH != null){
                        if(DicDoctorCertNoHM.containsKey(XDRGH.toString())){
                            Map ddc = DicDoctorCertNoHM.get(XDRGH.toString());
                            String certno = ddc.get("certno").toString();
                            row.put("XDRSFZHM", certno);
                        }else{
                            row.put("XDRSFZHM", "-");
                        }
                    }
                    Object ZXRGH = row.get("ZXRGH");
                    if(ZXRGH != null){
                        if(DicDoctorCertNoHM.containsKey(ZXRGH.toString())){
                            Map ddc = DicDoctorCertNoHM.get(ZXRGH.toString());
                            String certno = ddc.get("certno").toString();
                            row.put("ZXRSFZHM", certno);
                        }else{
                            row.put("ZXRSFZHM", "-");
                        }
                    }
                    String YZLX = row.get("YZLX").toString();
                    if(YZLX.equals("1")){
                        //处理院内药物剂型代码 院内药物剂型名称 中心药物剂型代码 中心药物剂型名称
                        Object YZMXBM = row.get("YZMXBM");
                        if(YZMXBM != null){
                            if(DicDrugJxInforHM.containsKey(YZMXBM.toString())){
                                Map ddji = DicDrugJxInforHM.get(YZMXBM.toString());
                                String ynywjxdm = ddji.get("ynywjxdm").toString();
                                String ynywjxmc = ddji.get("ynywjxmc").toString();
                                String ywjxdm = ddji.get("ywjxdm").toString();
                                String ywjxmc = ddji.get("ywjxmc").toString();
                                row.put("YNYWJXDM", ynywjxdm);
                                row.put("YNYWJXMC", ynywjxmc);
                                row.put("YWJXDM", ywjxdm);
                                row.put("YWJXMC", ywjxmc);
                            }else{
                                row.put("YNYWJXDM", "-");
                                row.put("YNYWJXMC", "-");
                                row.put("YWJXDM", "-");
                                row.put("YWJXMC", "-");
                            }
                        }
                        //处理中心用药频度代码 中心用药频度名称
                        Object YNYYPDDM = row.get("YNYYPDDM");
                        if(YNYYPDDM != null){
                            if(DicDrugPdInforHM.containsKey(YNYYPDDM.toString())){
                                Map ddpi = DicDrugPdInforHM.get(YNYYPDDM.toString());
                                String item_id = ddpi.get("item_id").toString();
                                String item_name = ddpi.get("item_name").toString();
                                row.put("YYPD", item_id);
                                row.put("YYPDMC", item_name);
                            }else{
                                row.put("YYPD", "-");
                                row.put("YYPDMC", "-");
                            }
                        }

                        //处理中心药品用法代码 中心药品用法名称
                        Object YNYPYFDM = row.get("YNYPYFDM");
                        if(YNYPYFDM != null){
                            if(DicDrugYfInforHM.containsKey(YNYPYFDM.toString())){
                                Map ddpi = DicDrugYfInforHM.get(YNYPYFDM.toString());
                                String item_id = ddpi.get("item_id").toString();
                                String item_name = ddpi.get("item_name").toString();
                                row.put("YPYF", item_id);
                                row.put("YPYFMC", item_name);
                            }else{
                                row.put("YPYF", "-");
                                row.put("YPYFMC", "-");
                            }
                        }
                    }
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYYZMXB(param);
                    for (Map row : rows) {
                        ld.deleteZYYZMXBByPk(row);
                        ld.insertZYYZMXB(row);
                    }
                }
            }
            //出院患者收费记录表
            if ("ZYSFJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZysfjlb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYSFJLB(param);
                    for (Map row : rows) {
                        ld.insertZYSFJLB(row);
                    }
                }
            }
            //出院患者收费明细表
            if ("ZYSFMXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZysfmxb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYSFMXB(param);
                    for (Map row : rows) {
                        ld.insertZYSFMXB(row);
                    }
                }
            }
            //住院出院小结报告/死亡记录
            if ("ZYCYXJBG".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZycyxjbg(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYCYXJBG(param);
                    for (Map row : rows) {
                        ld.insertZYCYXJBG(row);
                    }
                }
            }
            //入院登记信息
            if ("ZYRYDJB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyrydjb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYRYDJB(param);
                    for (Map row : rows) {
                        ld.insertZYRYDJB(row);
                    }
                }
            }
            //出院登记信息
            if ("ZYCYDJB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZycydjb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYCYDJB(param);
                    for (Map row : rows) {
                        ld.insertZYCYDJB(row);
                    }
                }
            }
            //住院预交金
            if ("ZYYJJ".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyyjj(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYYJJ(param);
                    for (Map row : rows) {
                        ld.insertZYYJJ(row);
                    }
                }
            }
            //住院费用发生明细
            if ("ZYFYFSMX".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyfyfsmx(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYFYFSMX(param);
                    for (Map row : rows) {
                        ld.insertZYFYFSMX(row);
                    }
                }
            }
            //西医病案首页
            if ("BA_SYJBK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryBa_syjbk(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteBA_SYJBKByPK(row);
                        try {
                            ld.insertBA_SYJBK(row);
                        }catch(Exception e){
                            String errorMessage = e.getMessage();
                            if(errorMessage.indexOf("无效数字") == -1){
                                throw e;
                            }
                        }
                    }
                }
            }
            //西医病案首页手术
            if ("BA_SYSSK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryBa_syssk(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteBA_SYSSK(param);
                    for (Map row : rows) {
                        ld.insertBA_SYSSK(row);
                    }
                }
            }
            //西医病案首页出院诊断
            if ("BA_SYZDK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryBa_syzdk(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteBA_SYZDKByPk(row);
                        ld.insertBA_SYZDK(row);
                    }
                }
            }
            //诊断明细报告
            if ("ZYZDMXBG".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyzdmxbg(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteZYZDMXBG(param);
                    for (Map row : rows) {
                        ld.insertZYZDMXBG(row);
                    }
                }
            }
            //检验记录表
            if ("JYJLB".equals(dataType.toUpperCase())) {
                List<Map> lis = hpf_lisDAO.queryJyjlb_lis(orgCode, begtime, endtime);
                hpfDAO.deleteJyjlb(orgCode);
                for (int i = 0; i < lis.size(); i++) {
                    hpfDAO.addJyjlb(lis.get(i));
                }
                List<Map> queryResult = hpfDAO.queryJyjlb_his(orgCode);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteJYJLBByPk(row);
                        ld.insertJYJLB(row);
                    }
                }
            }
            //检验明细表
            if ("JYMXB".equals(dataType.toUpperCase())) {
                List<Map> lis = hpf_lisDAO.queryJymxb_lis(orgCode, begtime, endtime);
                hpfDAO.deleteJymxb(orgCode);
                for (int i = 0; i < lis.size(); i++) {
                    hpfDAO.addJymxb(lis.get(i));
                }
                List<Map> queryResult = hpfDAO.queryJymxb_his(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteJYMXBByPk(row);
                        ld.insertJYMXB(row);
                    }
                }
            }
            //检验收费项目明细表
            if ("JYSFXMB".equals(dataType.toUpperCase())) {
                List<Map> lis = hpf_lisDAO.queryJysfxmb_lis(orgCode, begtime, endtime);
                hpfDAO.deleteJysfxmb(orgCode);
                for (int i = 0; i < lis.size(); i++) {
                    hpfDAO.addJysfxmb(lis.get(i));
                }
                List<Map> queryResult = hpfDAO.queryJysfxmb_his(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteJYSFXMBByPk(row);
                        ld.insertJYSFXMB(row);
                    }
                }
            }
            //检查记录表
            if ("JCJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJcjlb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteJCJLBByPk(row);
                        ld.insertJCJLB(row);
                    }
                }
            }
            //检查收费项目明细表
            if ("JCJLZB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJcjlzb_his(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteJCJLZBByPK(row);
                        ld.insertJCJLZB(row);
                    }
                }
            }
            //门(急)诊病历
            if ("EMR_MJZBL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryEmr_mjzbl(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    ld.deleteEMR_MJZBL(param);
                    for (Map row : rows) {
                        ld.insertEMR_MJZBL(row);
                    }
                }
            }
            //入院记录
            if ("EMR_RYJL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryEmr_ryjl(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteEMR_RYJLByPk(row);
                        ld.insertEMR_RYJL(row);
                    }
                }
            }
            //24h内入出院记录
            if ("EMR_CRYJL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryEmr_cryjl(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteEMR_CRYJLByPk(row);
                        ld.insertEMR_CRYJL(row);
                    }
                }
            }
            //24h内入院死亡记录
            if ("EMR_ZYSWJL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryEmr_zyswjl(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteEMR_ZYSWJLByPk(row);
                        ld.insertEMR_ZYSWJL(row);
                    }
                }
            }
            //门（急）诊统计表（日报）
            if ("TJ_MJZ_RB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryTj_mjz_rb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteTJ_MJZ_RBByPK(row);
                        ld.insertTJ_MJZ_RB(row);
                    }
                }
            }
            //住院统计表（日报）
            if ("TJ_ZY_RB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryTj_zy_rb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteTJ_ZY_RBByPK(row);
                        ld.insertTJ_ZY_RB(row);
                    }
                }
            }
            //住院工作量及病床分科统计表（日报）
            if ("TJ_ZYGZL_KS_RB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryTj_zygzl_ks_rb(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteTJ_ZYGZL_KS_RBByPK(row);
                        ld.insertTJ_ZYGZL_KS_RB(row);
                    }
                }
            }
            //床位占用情况表
            if ("TJ_SSYW_CWZYQK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryTj_ssyw_cwzyqk(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteTJ_SSYW_CWZYQKByPK(row);
                        ld.insertTJ_SSYW_CWZYQK(row);
                    }
                }
            }
            //首次病程记录
            if ("EMR_SCBCJL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = this.queryScbc(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteEMR_SCBCJLByPK(row);
                        ld.insertEMR_SCBCJL(row);
                    }
                }
            }
            //日常病程记录
            if ("EMR_RCBCJL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = this.queryRcbc(orgCode, begtime, endtime);
                for (int i = 0; i < queryResult.size(); i++) {
                    queryResult.get(i).put("YLJGDM", "12370683MB2637101K");
                }
                result = gson.toJson(queryResult);
                if (isTest) {
                    List<Map> rows = queryResult;
                    for (Map row : rows) {
                        ld.deleteEMR_RCBCJLByPK(row);
                        ld.insertEMR_RCBCJL(row);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("----------------莱州卫健接口抽取异常---------------------------");
            System.out.println(dataType + "   出现异常");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------");

            log.info("----------------莱州卫健接口抽取异常---------------------------");
            log.info(dataType + "   出现异常");
            log.info(e.getMessage());
            log.info("-------------------------------------------");
        }

        return result;
    }

    public void insertLog(String begtime, String endtime, String dataType, String begTimeStamp, String endTimeStamp, String message) {
        Gson gson = new Gson();
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("table", dataType);
        hm.put("begtime", begtime);
        hm.put("endtime", endtime);
        String hmJson = gson.toJson(hm);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("begTime", begTimeStamp);
        param.put("endTime", endTimeStamp);
        if ("成功".equals(message)) {
            param.put("run_result", "成功");
        } else {
            param.put("run_result", "失败");
        }
        param.put("comments", message);
        param.put("auto_type", "JAVA");
        param.put("orgCode", "H37061200001");
        param.put("service_code", "莱州卫健");
        param.put("service_name", "莱州卫健");
        param.put("params", hmJson);
        hpfDAO.insertSI_YTAUTORUNLOG(param);
    }

    public void genSqlString(String tableName, Map columnSet) {
        Iterator iterator = columnSet.keySet().iterator();
        ArrayList al = new ArrayList();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            al.add(key);
        }
        System.out.println("-------------------------------------------");
        System.out.println("<delete id=\"delete" + tableName + "\" parameterType=\"HashMap\">");
        System.out.println("delete from " + tableName + " where ");
        System.out.println("</delete>");
        System.out.println("<insert id=\"insert" + tableName + "\" parameterType=\"java.util.HashMap\">");
        String sql = "insert into " + tableName + "(";
        for (int i = 0; i < al.size(); i++) {
            if (i % 10 == 0) {
                sql = sql + "\n";
            }
            sql = sql + al.get(i).toString() + ", ";

        }
        sql = sql.substring(0, sql.length() - 2) + ") values (";
        for (int i = 0; i < al.size(); i++) {
            if (i % 10 == 0) {
                sql = sql + "\n";
            }
            String str = al.get(i).toString();
            if (str.endsWith("SJ") && str.endsWith("RQ")) {
                sql = sql + "#{" + al.get(i) + ", jdbcType=dateTime}, ";
            } else {
                sql = sql + "#{" + al.get(i) + ", jdbcType=VARCHAR}, ";
            }

        }
        sql = sql.substring(0, sql.length() - 2) + ")";
        System.out.println(sql);
        System.out.println("</insert>");
        System.out.println("-------------------------------------------");
    }

    public static String decodeBase64AndGZip(String input) {
        byte[] bytes;
        String out = input;

        try (ByteArrayInputStream bis = new ByteArrayInputStream(Base64.getDecoder().decode(input));
             GZIPInputStream gzip = new GZIPInputStream(bis);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int num;
            while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                bos.write(buf, 0, num);
            }
            bytes = bos.toByteArray();
            out = new String(bytes, StandardCharsets.UTF_8);
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    public List<Map> queryScbc(String orgcode, String begtime, String endtime) {
        List<Map> list2 = hpfDAO.query(orgcode, begtime, endtime);
        hpfDAO.delete();
        for (int i = 0; i < list2.size(); i++) {
            Clob clob = null;
            String text = "";
            String result = "";
            try {
                if (list2.get(i).containsKey("TEXT2")) {
                    clob = (Clob) list2.get(i).get("TEXT2");
                    text = clob.getSubString(1, (int) clob.length());
                    String info = this.decodeBase64AndGZip(text);
                    result = info.replaceAll("<.*?>", "");
                    String bltd = result.substring(result.indexOf("病例特点：") + 5, result.indexOf("诊断"));
                    if (bltd.length() > 1300) {
                        bltd = bltd.substring(0, 1300);
                    }
                    String zdyj = result.substring(result.indexOf("鉴别诊断：") + 5, result.indexOf("诊疗计划")).replace("&nbsp;", "");
                    if (zdyj.length() > 1300) {
                        zdyj = zdyj.substring(0, 1300);
                    }
                    String zljh = result.substring(result.indexOf("诊疗计划：") + 5).replace("&nbsp;", "");
                    if (zljh.length() > 600) {
                        zljh = zljh.substring(0, 600);
                    }
                    list2.get(i).remove("TEXT2");
                    list2.get(i).put("BLTD", bltd);
                    list2.get(i).put("ZDYJ", zdyj);
                    list2.get(i).put("ZLJH", zljh);
                    Map<String, String> map = new HashMap<>();
                    map.put("ORGCODE", list2.get(i).get("ORGCODE").toString());
                    map.put("INID", list2.get(i).get("INID").toString());
                    map.put("JLRQSJ", list2.get(i).get("JLRQSJ").toString());
                    map.put("BLTD", list2.get(i).get("BLTD").toString());
                    map.put("ZDYJ", list2.get(i).get("ZDYJ").toString());
                    map.put("ZLJH", list2.get(i).get("ZLJH").toString());
                    hpfDAO.add(map);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        List<Map> list1 = hpfDAO.queryZs(orgcode);
        for (int i = 0; i < list1.size(); i++) {
            Clob clob = null;
            String text = "";
            String result = "";
            try {
                if (list1.get(i).containsKey("TEXT2")) {
                    clob = (Clob) list1.get(i).get("TEXT2");
                    text = clob.getSubString(1, (int) clob.length());
                    String info2 = this.decodeBase64AndGZip(text);
                    result = info2.replaceAll("<.*?>", "");
                    String zs = result.substring(result.indexOf("诉：") + 2, result.indexOf("现病史：")).replace("&nbsp;", "");
                    ;
                    if (zs.length() > 330) {
                        zs = zs.substring(0, 330);
                    }
                    list1.get(i).remove("TEXT2");
                    list1.get(i).put("ZS", zs);
                    hpfDAO.update(list1.get(i).get("INID").toString(), list1.get(i).get("ORGCODE").toString(), list1.get(i).get("ZS").toString());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        List<Map> list = hpfDAO.queryEmr_scbcjl(orgcode);
        return list;
    }

    public List<Map> queryRcbc(String orgcode, String begtime, String endtime) {
        List<Map> list1 = hpfDAO.queryEmr_rcbcjl(orgcode, begtime, endtime);
        for (int i = 0; i < list1.size(); i++) {
            Clob clob = null;
            String text = "";
            String result = "";
            try {
                if (list1.get(i).containsKey("ZYBC")) {
                    clob = (Clob) list1.get(i).get("ZYBC");
                    text = clob.getSubString(1, (int) clob.length());
                    String info2 = this.decodeBase64AndGZip(text);
                    result = info2.replaceAll("<.*?>", "");
                    String zybc = result.replace("&nbsp;", "");
                    if (zybc.length() > 600) {
                        zybc = zybc.substring(0, 600);
                    }
                    list1.get(i).put("ZYBC", zybc);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list1;
    }
}