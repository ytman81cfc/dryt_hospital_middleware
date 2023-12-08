package com.hospital.middleware.healthplatform.service;

import com.google.gson.Gson;
import com.hospital.middleware.healthplatform.dao.his.HealthplatfromDAO;
import com.hospital.middleware.healthplatform.dao.lis.Healthplatform_lisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class HpService {
    @Autowired
    private HealthplatfromDAO hpfDAO;
    private Healthplatform_lisDAO hpf_lisDAO;

    public String queryData(String begtime, String endtime, String dataType){
        String orgCode = "H37068300546";
        Gson gson = new Gson();
        String result = "";
        begtime = begtime + " 00:00:00";
        endtime = endtime + " 23:59:59";
        try {
            //材料目录
            if ("JB_CLML".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJb_clml(orgCode);
                result = gson.toJson(queryResult);
            }
            //收费项目目录
            if ("JB_XMML".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJb_xmml(orgCode);
                result = gson.toJson(queryResult);
            }
            //病区信息
            if ("JBBQXXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJbbqxxb(orgCode);
                result = gson.toJson(queryResult);
            }
            //科室信息
            if ("JBKSXXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJbksxxb(orgCode);
                result = gson.toJson(queryResult);
            }
            //医护人员信息表
            if ("JBYHRYXXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJbyhryxxb(orgCode);
                result = gson.toJson(queryResult);
            }
            //疾病诊断目录, 目前对所有机构而言, 机构代码都是370600
            if ("JB_ZDML".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJb_zdml("370600");
                result = gson.toJson(queryResult);
            }
            //手术目录, 目前对所有机构而言, 机构代码都是370600
            if ("JB_SSML".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJb_ssml("370600");
                result = gson.toJson(queryResult);
            }
            //药品基本信息
            if ("YP_JBXXK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryYp_jbxxk(orgCode);
                result = gson.toJson(queryResult);
            }
            //患者基本信息表
            if ("JBBRJBXXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJbbrjbxxb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }

            //门诊挂号表
            if ("MZGHB".equals(dataType.toUpperCase())) {
                List<Map> queryResult_gh = hpfDAO.queryMzghb(orgCode, begtime, endtime);
                List<Map> queryResult_th = hpfDAO.queryMzthb(orgCode, begtime, endtime);
                List<Map> queryResult = new ArrayList<Map>();
                queryResult.addAll(queryResult_gh);
                queryResult.addAll(queryResult_th);
                result = gson.toJson(queryResult);
            }
            //门诊就诊记录表
            if ("MZJZJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryMzjzjlb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //门诊医嘱明细表
            if ("MZYZMXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryMzyzmxb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //门诊收费记录表
            if ("MZSFJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult_sf = hpfDAO.queryMzsfjlbsf(orgCode, begtime, endtime);
                List<Map> queryResult_tf = hpfDAO.queryMzsfjlbtf(orgCode, begtime, endtime);
                List<Map> queryResult = new ArrayList<Map>();
                queryResult.addAll(queryResult_sf);
                queryResult.addAll(queryResult_tf);
                result = gson.toJson(queryResult);
            }
            //门诊收费明细表
            if ("MZSFMXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult_sf = hpfDAO.queryMzsfmxbsf(orgCode, begtime, endtime);
                List<Map> queryResult_tf = hpfDAO.queryMzsfmxbtf(orgCode, begtime, endtime);
                List<Map> queryResult = new ArrayList<Map>();
                queryResult.addAll(queryResult_sf);
                queryResult.addAll(queryResult_tf);
                result = gson.toJson(queryResult);
            }
            //门诊费用结算信息
            if ("MZFYJSXX".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryMzfyjsxx(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }

            //住院就诊记录表
            if ("ZYJZJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyjzjlb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //住院医嘱明细表
            if ("ZYYZMXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyyzmxb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //出院患者收费记录表
            if ("ZYSFJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZysfjlb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //出院患者收费明细表
            if ("ZYSFMXB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZysfmxb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //住院出院小结报告/死亡记录
            if ("ZYCYXJBG".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZycyxjbg(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //入院登记信息
            if ("ZYRYDJB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyrydjb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //出院登记信息
            if ("ZYCYDJB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZycydjb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //住院预交金
            if ("ZYYJJ".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyyjj(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //住院费用发生明细
            if ("ZYFYFSMX".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyfyfsmx(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //西医病案首页
            if ("BA_SYJBK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryBa_syjbk(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //检验收费项目明细表
            if ("JYSFXMB".equals(dataType.toUpperCase())) {
                List<Map> lis=hpf_lisDAO.queryJysfxmb_lis(orgCode, begtime, endtime);
                hpfDAO.delete(orgCode, begtime, endtime);
                hpfDAO.add(orgCode, begtime, endtime);
                List<Map> queryResult = hpfDAO.queryJysfxmb_his(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
                genSqlString("JYSFXMB", queryResult.get(0));
            }

        } catch (Exception e){
            System.out.println("-------------------------------------------");
            System.out.println(dataType);
            System.out.println("出现异常");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------");
        }




        return result;
    }

    public void genSqlString(String tableName, Map columnSet){
        Iterator iterator = columnSet.keySet().iterator();
        ArrayList al = new ArrayList();
        while(iterator.hasNext()){
            String key = iterator.next().toString();
            al.add(key);
        }
        System.out.println("-------------------------------------------");
        System.out.println("<delete id=\"delete" + tableName + "\" parameterType=\"HashMap\">");
        System.out.println("delete from " + tableName + " where ");
        System.out.println("</delete>");
        System.out.println("<insert id=\"insert" + tableName + "\" parameterType=\"java.util.HashMap\">");
        String sql = "insert into " + tableName + "(";
        for(int i = 0; i < al.size(); i++){
            if(i%10 == 0){
                sql = sql + "\n";
            }
            sql = sql + al.get(i).toString() + ", ";

        }
        sql = sql.substring(0, sql.length() -2) + ") values (";
        for(int i = 0; i < al.size(); i++){
            if(i%10 == 0){
                sql = sql + "\n";
            }
            String str = al.get(i).toString();
            if(str.endsWith("SJ") && str.endsWith("RQ")){
                sql = sql + "#{" + al.get(i) + ", jdbcType=dateTime}, ";
            }else{
                sql = sql + "#{" + al.get(i) + ", jdbcType=VARCHAR}, ";
            }

        }
        sql = sql.substring(0, sql.length() -2) + ")";
        System.out.println(sql);
        System.out.println("</insert>");
        System.out.println("-------------------------------------------");
    }
}