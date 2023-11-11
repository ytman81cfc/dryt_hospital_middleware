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
            List<Map<String, String>> qmResult = medicalrecordDAO.queryMedcard("H37068300546", relprimary);
            Map qmMap = qmResult.get(0);
            String qm_rr = "";
            Iterator iterator = qmMap.keySet().iterator();
            while(iterator.hasNext()){
                String key = iterator.next().toString();
                String value = "";
                if(qmMap.get(key) != null){
                    value = String.valueOf(qmMap.get(key));
                    value = value.replaceAll("<", "&lt;");
                    value = value.replaceAll(">", "&gt;");
                }else{
                    value = null;
                }
                qm_rr = qm_rr + "<" + key + ">" + value + "</" + key + ">";
            }
            qm_rr = "<medcard>" + qm_rr + "</medcard>";

            List<Map<String, String>> qiResult = medicalrecordDAO.queryIcde("H37068300546", relprimary);
            String qi_rr = "<icdes>";
            for(int i = 0; i < qiResult.size(); i++){
                Map<String, String> qiMap = qiResult.get(i);
                qi_rr = qi_rr + "<icde>";
                Iterator qi_iterator = qiMap.keySet().iterator();
                while(qi_iterator.hasNext()){
                    String key = qi_iterator.next().toString();
                    String value = "";
                    if(qiMap.get(key) != null){
                        value = String.valueOf(qiMap.get(key));
                        value = value.replaceAll("<", "&lt;");
                        value = value.replaceAll(">", "&gt;");
                    }else{
                        value = null;
                    }
                    qi_rr = qi_rr + "<" + key + ">" + value + "</" + key + ">";
                }
                qi_rr = qi_rr + "</icde>";
            }
            qi_rr = qi_rr + "</icdes>";

            List<Map<String, String>> qoResult = medicalrecordDAO.queryOper("H37068300546", relprimary);
            String qo_rr = "<opers>";
            for(int i = 0; i < qoResult.size(); i++) {
                Map<String, String> qoMap = qoResult.get(i);
                qo_rr = qo_rr + "<oper>";
                Iterator qo_iterator = qoMap.keySet().iterator();
                while(qo_iterator.hasNext()){
                    String key = qo_iterator.next().toString();
                    String value = "";
                    if(qoMap.get(key) != null){
                        value = String.valueOf(qoMap.get(key));
                        value = value.replaceAll("<", "&lt;");
                        value = value.replaceAll(">", "&gt;");
                    }else{
                        value = null;
                    }
                    qo_rr = qo_rr + "<" + key + ">" + value + "</" + key + ">";
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
}