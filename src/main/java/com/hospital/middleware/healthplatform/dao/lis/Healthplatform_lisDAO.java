package com.hospital.middleware.healthplatform.dao.lis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Healthplatform_lisDAO {

    //检验记录表
    List<Map> queryJyjlb_lis(String orgcode, String begtime, String endtime);
    List<Map> queryJysfxmb_lis(String orgcode, String begtime, String endtime);
    List<Map> queryJymxb_lis(String orgcode, String begtime, String endtime);
}
