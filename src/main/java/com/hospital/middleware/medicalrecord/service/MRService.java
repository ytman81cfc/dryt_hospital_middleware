package com.hospital.middleware.medicalrecord.service;

import com.hospital.middleware.medicalrecord.dao.his.MedicalrecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MRService {

    @Autowired
    private MedicalrecordDAO medicalrecordDAO;

    public String QryMedCardListByOutDate(String startdt, String enddt){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("startdt", startdt.trim() + " 00:00:00");
            param.put("enddt", enddt.trim() + " 23:59:59");
            param.put("orgcode", "H37068300546");
            List<Map> qr = medicalrecordDAO.qryMedCardListByOutDate(param);
            String t_rr = "";
            for (int i = 0; i < qr.size(); i++) {
                t_rr = t_rr + "<relprimary>" + qr.get(i).get("relprimary") + "</relprimary>";
            }
            String rr = "<result>" +
                    "<resultflag>1</resultflag>" +
                    "<resultmsg>成功</resultmsg>" +
                    "<medcard>" + t_rr + "</medcard>" +
                    "</result>";

            return rr;
        }catch(Exception e){
            return  "<result>" +
                    "<resultflag>0</resultflag>" +
                    "<resultmsg>"+e.getMessage()+"</resultmsg>" +
                    "</result>";
        }
    }

    public String QryMedCardListByPatNo(String patNo){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("patNo", patNo);
            param.put("orgcode", "H37068300546");
            List<Map> qr = medicalrecordDAO.qryMedCardListByPatNo(param);
            String t_rr = "";
            for (int i = 0; i < qr.size(); i++) {
                t_rr = t_rr + "<relprimary>" + qr.get(i).get("relprimary") + "</relprimary>";
            }
            String rr = "<result>" +
                    "<resultflag>1</resultflag>" +
                    "<resultmsg>成功</resultmsg>" +
                    "<medcard>" + t_rr + "</medcard>" +
                    "</result>";

            return rr;
        }catch(Exception e){
            return  "<result>" +
                        "<resultflag>0</resultflag>" +
                        "<resultmsg>"+e.getMessage()+"</resultmsg>" +
                    "</result>";
        }
    }

    public String GetMedCardXml(String relprimary){
        try {
            List<Map> qmResult = medicalrecordDAO.queryMedcard("H37068300546", relprimary);
            Map qmMap = qmResult.get(0);
            //genSqlString("medcard", qmMap);
            String qm_rr = "";
            Iterator iterator = qmMap.keySet().iterator();
            while(iterator.hasNext()){
                String key = iterator.next().toString();
                qm_rr = qm_rr + "<" + key + ">" + qmMap.get(key) + "</" + key + ">";
            }
            qm_rr = "<medcard>" + qm_rr + "</medcard>";

            List<Map> qiResult = medicalrecordDAO.queryIcde("H37068300546", relprimary);
            String qi_rr = "<icdes>";
            for(int i = 0; i < qiResult.size(); i++){
                Map qiMap = qiResult.get(i);
                //genSqlString("icde", qiMap);
                qi_rr = qi_rr + "<icde>";
                Iterator qi_iterator = qiMap.keySet().iterator();
                while(qi_iterator.hasNext()){
                    String key = qi_iterator.next().toString();
                    qi_rr = qi_rr + "<" + key + ">" + qiMap.get(key) + "</" + key + ">";
                }
                qi_rr = qi_rr + "</icde>";
            }
            qi_rr = qi_rr + "</icdes>";

            List<Map> qoResult = medicalrecordDAO.queryOper("H37068300546", relprimary);
            String qo_rr = "<opers>";
            for(int i = 0; i < qoResult.size(); i++) {
                Map qoMap = qoResult.get(i);
                //genSqlString("oper", qoMap);
                qo_rr = qo_rr + "<oper>";
                Iterator qo_iterator = qoMap.keySet().iterator();
                while(qo_iterator.hasNext()){
                    String key = qo_iterator.next().toString();
                    qo_rr = qo_rr + "<" + key + ">" + qoMap.get(key) + "</" + key + ">";
                }
                qo_rr = qo_rr + "</oper>";
            }
            qo_rr = qo_rr + "</opers>";


            String rr = "<result>" +
                            "<resultflag>1</resultflag>" +
                            "<resultmsg>成功</resultmsg>" +
                            qm_rr +
                            qi_rr +
                            qo_rr +
                            "</result>";
            return rr;
        }catch(Exception e){
            return  "<result>" +
                    "<resultflag>0</resultflag>" +
                    "<resultmsg>"+e.getMessage()+"</resultmsg>" +
                    "</result>";
        }
    }

    public void genSqlString(String tableName, Map columnSet){
        Iterator iterator = columnSet.keySet().iterator();
        ArrayList al = new ArrayList();
        while(iterator.hasNext()){
            String key = iterator.next().toString();
            al.add(key);
        }
        System.out.println("<insert id=\"insert" + tableName + "\" parameterType=\"java.util.HashMap\">");
        String sql = "insert into " + tableName + "(";
        for(int i = 0; i < al.size(); i++){
            sql = sql + al.get(i).toString() + ", ";
        }
        sql = sql.substring(0, sql.length() -2) + ") values (";
        for(int i = 0; i < al.size(); i++){
            sql = sql + "#{" + al.get(i) + ", jdbcType=VARCHAR}, ";
        }
        sql = sql.substring(0, sql.length() -2) + ")";
        System.out.println(sql);
        System.out.println("</insert>");
    }


}