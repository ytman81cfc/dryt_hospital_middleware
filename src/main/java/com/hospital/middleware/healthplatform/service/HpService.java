package com.hospital.middleware.healthplatform.service;

import com.google.gson.Gson;
import com.hospital.middleware.healthplatform.dao.his.HealthplatfromDAO;
import com.hospital.middleware.healthplatform.dao.lis.Healthplatform_lisDAO;
import org.apache.commons.io.output.ByteArrayOutputStream;
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
            //西医病案首页手术
            if ("BA_SYSSK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryBa_syssk(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //西医病案首页出院诊断
            if ("BA_SYZDK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryBa_syzdk(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //诊断明细报告
            if ("ZYZDMXBG".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryZyzdmxbg(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }

            //检验明细表
            if ("JYMXB".equals(dataType.toUpperCase())) {
                List<Map> lis=hpf_lisDAO.queryJymxb_lis(orgCode, begtime, endtime);
                hpfDAO.deleteJymxb(orgCode);
                for(int i = 0; i < lis.size(); i++){
                hpfDAO.addJymxb(lis.get(i));
                }
                List<Map> queryResult = hpfDAO.queryJymxb_his(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
             }
            //检验收费项目明细表
            if ("JYSFXMB".equals(dataType.toUpperCase())) {
                List<Map> lis=hpf_lisDAO.queryJysfxmb_lis(orgCode, begtime, endtime);
                hpfDAO.deleteJysfxmb(orgCode);
                for(int i = 0; i < lis.size(); i++){
                    hpfDAO.addJysfxmb(lis.get(i));
                }
                List<Map> queryResult = hpfDAO.queryJysfxmb_his(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
             }
            //检查记录表
            if ("JCJLB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJcjlb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //检查收费项目明细表
            if ("JCJLZB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryJcjlzb_his(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //门(急)诊病历
            if ("EMR_MJZBL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryEmr_mjzbl(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //入院记录
            if ("EMR_RYJL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryEmr_ryjl(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //24h内入出院记录
            if ("EMR_CRYJL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryEmr_cryjl(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //24h内入院死亡记录
            if ("EMR_ZYSWJL".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryEmr_zyswjl(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //门（急）诊统计表（日报）
            if ("TJ_MJZ_RB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryTj_mjz_rb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //住院统计表（日报）
            if ("TJ_ZY_RB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryTj_zy_rb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //住院工作量及病床分科统计表（日报）
            if ("TJ_ZYGZL_KS_RB".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryTj_zygzl_ks_rb(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //床位占用情况表
            if ("TJ_SSYW_CWZYQK".equals(dataType.toUpperCase())) {
                List<Map> queryResult = hpfDAO.queryTj_ssyw_cwzyqk(orgCode, begtime, endtime);
                result = gson.toJson(queryResult);
            }
            //首次病程记录
            if ("EMR_SCBCJL".equals(dataType.toUpperCase())) {
                List<Map> list=this.queryScbc(orgCode, begtime, endtime);
                //List<Map> queryResult = hpfDAO.queryJysfxmb_his(orgCode, begtime, endtime);
                result = gson.toJson(list);
            }
            //日常病程记录
            if ("EMR_RCBCJL".equals(dataType.toUpperCase())) {
                List<Map> list=this.queryRcbc(orgCode, begtime, endtime);
                result = gson.toJson(list);
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
    public List<Map> queryScbc(String orgcode ,String begtime, String endtime) {
        List<Map> list1=hpfDAO.queryZs(orgcode,begtime,endtime);
        hpfDAO.delete();
        for (int i = 0; i < list1.size(); i++) {
            Clob clob = null;
            String text = "";
            String result = "";
            try {
                if (list1.get(i).containsKey("TEXT2")) {
                    clob = (Clob) list1.get(i).get("TEXT2");
                    text = clob.getSubString(1, (int) clob.length());
                    String info2 = this.decodeBase64AndGZip(text);
                    result=info2.replaceAll("<.*?>", "");
                    String zs=result.substring(result.indexOf("诉：")+2,result.indexOf("现病史：")).replace("&nbsp;", "");;
                    list1.get(i).remove("TEXT2");
                    list1.get(i).put("ZS", zs);
                    hpfDAO.add(list1.get(i).get("INID").toString(),list1.get(i).get("ORGCODE").toString(),list1.get(i).get("ZS").toString());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /*List<Map> list2 = hpfDAO.query(orgcode);
        for (int i = 0; i < list2.size(); i++) {
            Clob clob = null;
            String text = "";
            String result = "";
            try {
                if (list2.get(i).containsKey("TEXT2")) {
                    clob = (Clob) list2.get(i).get("TEXT2");
                    text = clob.getSubString(1, (int) clob.length());
                    String info = this.decodeBase64AndGZip(text);
                    result=info.replaceAll("<.*?>", "");
                    String bltd=result.substring(result.indexOf("病例特点：")+5,result.indexOf("初步诊断"));
                    String zdyj=result.substring(result.indexOf("鉴别诊断：")+5,result.indexOf("诊疗计划")).replace("&nbsp;", "");
                    String zljh=result.substring(result.indexOf("诊疗计划：")+5).replace("&nbsp;", "");
                    list2.get(i).remove("TEXT2");
                    list2.get(i).put("BLTD", bltd);
                    list2.get(i).put("ZDYJ", zdyj);
                    list2.get(i).put("ZLJH", zljh);
                    Map<String,String> map=new HashMap<>();
                    map.put("ORGCODE",list2.get(i).get("ORGCODE").toString());
                    map.put("INID",list2.get(i).get("INID").toString());
                    map.put("JLRQSJ",list2.get(i).get("JLRQSJ").toString());
                    map.put("BLTD",list2.get(i).get("BLTD").toString());
                    map.put("ZDYJ",list2.get(i).get("ZDYJ").toString());
                    map.put("ZLJH",list2.get(i).get("ZLJH").toString());
                    hpfDAO.update(map);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        List<Map> list=hpfDAO.queryEmr_scbcjl(orgcode);
        return list;
    }
    public List<Map> queryRcbc(String orgcode ,String begtime, String endtime) {
        List<Map> list1=hpfDAO.queryEmr_rcbcjl(orgcode,begtime,endtime);
        // hpfDAO.delete();
        for (int i = 0; i < list1.size(); i++) {
            Clob clob = null;
            String text = "";
            String result = "";
            try {
                if (list1.get(i).containsKey("ZYBC")) {
                    clob = (Clob) list1.get(i).get("ZYBC");
                    text = clob.getSubString(1, (int) clob.length());
                    String info2 = this.decodeBase64AndGZip(text);
                    result=info2.replaceAll("<.*?>", "");
                    list1.get(i).put("ZYBC",result.replace("&nbsp;",""));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list1;
    }
}