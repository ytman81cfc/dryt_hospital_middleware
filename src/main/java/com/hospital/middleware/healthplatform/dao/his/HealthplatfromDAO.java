package com.hospital.middleware.healthplatform.dao.his;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HealthplatfromDAO {
    public void insertSI_YTAUTORUNLOG(Map<String, String> param);
    //JBYHRYXXB 医护人员信息表
    List<Map> queryJbyhryxxb(String orgcode);
    //JBKSXXB 科室信息
    List<Map> queryJbksxxb(String orgcode);
    //JBBQXXB 病区信息
    List<Map> queryJbbqxxb(String orgcode);
    //JB_XMML 收费项目目录
    List<Map> queryJb_xmml(String orgcode);
    //JB_CLML 材料目录
    List<Map> queryJb_clml(String orgcode);
    //JB_ZDML 疾病诊断目录
    List<Map> queryJb_zdml(String orgcode);
    //JB_SSML 手术目录
    List<Map> queryJb_ssml(String orgcode);
    //YP_JBXXK 药品基本信息
    List<Map> queryYp_jbxxk(String orgcode);
    //JBBRJBXXB 患者基本信息表
    List<Map> queryJbbrjbxxb(String orgcode,String begtime,String endtime);

    //MZGHB 门诊挂号表
    //挂号
    List<Map> queryMzghb(String orgcode,String begtime,String endtime);
    //退号
    List<Map> queryMzthb(String orgcode,String begtime,String endtime);

    //MZJZJLB 门诊就诊记录表
    List<Map> queryMzjzjlb(String orgcode,String begtime,String endtime);
    //MZYZMXB 门诊医嘱明细表
    List<Map> queryMzyzmxb(String orgcode,String begtime,String endtime);

    //MZSFJLB 门诊收费记录表
    //收费
    List<Map> queryMzsfjlbsf(String orgcode,String begtime,String endtime);
    //退费
    List<Map> queryMzsfjlbtf(String orgcode,String begtime,String endtime);

    //MZSFMXB 门诊收费明细表
    //收费
    List<Map> queryMzsfmxbsf(String orgcode,String begtime,String endtime);
    //退费
    List<Map> queryMzsfmxbtf(String orgcode,String begtime,String endtime);

    //MZFYJSXX 门诊费用结算信息
    List<Map> queryMzfyjsxx(String orgcode,String begtime,String endtime);

    //ZYJZJLB 住院就诊记录表
    List<Map> queryZyjzjlb(String orgcode,String begtime,String endtime);
    //ZYYZMXB 住院医嘱明细表
    List<Map> queryZyyzmxb(String orgcode,String begtime,String endtime);
    //ZYSFJLB 出院患者收费记录表
    List<Map> queryZysfjlb(String orgcode,String begtime,String endtime);
    //ZYSFMXB 出院患者收费明细表
    List<Map> queryZysfmxb(String orgcode,String begtime,String endtime);

    //ZYCYXJBG 住院出院小结报告/死亡记录
    List<Map> queryZycyxjbg(String orgcode,String begtime,String endtime);
    //ZYRYDJB 入院登记信息
    List<Map> queryZyrydjb(String orgcode,String begtime,String endtime);
    //ZYCYDJB 出院登记信息
    List<Map> queryZycydjb(String orgcode,String begtime,String endtime);
    //ZYYJJ 住院预交金
    List<Map> queryZyyjj(String orgcode,String begtime,String endtime);
    //ZYFYFSMX 住院费用发生明细
    List<Map> queryZyfyfsmx(String orgcode,String begtime,String endtime);

    //BA_SYJBK 西医病案首页
    List<Map> queryBa_syjbk(String orgcode,String begtime,String endtime);
    //BA_SYSSK 西医病案首页手术
    List<Map> queryBa_syssk(String orgcode,String begtime,String endtime);
    //BA_SYZDK 西医病案首页出院诊断
    List<Map> queryBa_syzdk(String orgcode,String begtime,String endtime);

    //ZYZDMXBG 诊断明细报告
    List<Map> queryZyzdmxbg(String orgcode,String begtime,String endtime);
    //JYJLB 检验记录表
    void deleteJyjlb (String orgcode );
    void addJyjlb (Map map);
    List<Map> queryJyjlb_his(String orgcode);
    //JYMXB 检验明细表
    void deleteJymxb (String orgcode );
    void addJymxb (Map map);
    List<Map> queryJymxb_his(String orgcode,String begtime,String endtime);
    //JYSFXMB 检验收费项目明细表
    void deleteJysfxmb (String orgcode );
    void addJysfxmb (Map<String,String> map);
    List<Map> queryJysfxmb_his(String orgcode,String begtime,String endtime);
    //检查记录表 JCJLB
    List<Map> queryJcjlb(String orgcode,String begtime,String endtime);
    // 检查收费项目明细表 JCJLZB
    List<Map> queryJcjlzb_his(String orgcode,String begtime,String endtime);

    //EMR_MJZBL 门(急)诊病历
    List<Map> queryEmr_mjzbl(String orgcode,String begtime,String endtime);

    //EMR_RYJL 入院记录
    List<Map> queryEmr_ryjl(String orgcode,String begtime,String endtime);
    //EMR_CRYJL 24h内入出院记录
    List<Map> queryEmr_cryjl(String orgcode,String begtime,String endtime);
    //EMR_ZYSWJL 24h内入院死亡记录
    List<Map> queryEmr_zyswjl(String orgcode,String begtime,String endtime);

    //TJ_MJZ_RB 门（急）诊统计表（日报）
    List<Map> queryTj_mjz_rb(String orgcode,String begtime,String endtime);
    //TJ_ZY_RB 住院统计表（日报）
    List<Map> queryTj_zy_rb(String orgcode,String begtime,String endtime);
    //TJ_ZYGZL_KS_RB 住院工作量及病床分科统计表（日报）
    List<Map> queryTj_zygzl_ks_rb(String orgcode,String begtime,String endtime);
    //TJ_SSYW_CWZYQK 床位占用情况表
    List<Map> queryTj_ssyw_cwzyqk(String orgcode,String begtime,String endtime);

    //EMR_SCBCJL 首次病程记录
    List<Map> query (String orgcode,String begtime,String endtime);
    List<Map> queryZs (String orgcode);
    void delete();
    void add(Map<String,String> map);
    void update(String inid,String orgcode,String zs);
    List<Map> queryEmr_scbcjl(String orgcode);
    //EMR_RCBCJL 日常病程记录
    List<Map> queryEmr_rcbcjl (String orgcode,String begtime,String endtime);


    //查询莱州卫健科室对应关系
    List<Map> queryDicDeptCompare(String orgcode);
    //查询员工身份证号
    List<Map> queryDicDoctorCertNo(String orgcode);
    //查询药品 院内药物剂型代码 院内药物剂型名称 中心药物剂型代码 中心药物剂型名称
    List<Map> queryDicDrugJxInfor(String orgcode);
    //查询药品 中心用药频度代码 中心用药频度名称
    List<Map> queryDicDrugPdInfor(String orgcode);
    //查询药品 中心药品用法代码 中心药品用法名称
    List<Map> queryDicDrugYfInfor(String orgcode);



}