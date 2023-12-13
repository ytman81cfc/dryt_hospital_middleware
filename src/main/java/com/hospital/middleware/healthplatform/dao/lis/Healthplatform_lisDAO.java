package com.hospital.middleware.healthplatform.dao.lis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Healthplatform_lisDAO {

    //检验记录表
    List<Map> queryJyjlb_lis(String orgcode, String begtime, String endtime);
    //JYMXB 检验明细表
    List<Map> queryJymxb_lis(String orgcode, String begtime, String endtime);
    //JYSFXMB 检验收费项目明细表
    List<Map> queryJysfxmb_lis(String orgcode, String begtime, String endtime);

}
