package com.hospital.middleware.rationaldruguse.dao.lis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MsLabInfo_zy_lisDAO {

    //List<Map> queryMsLabInfo_zy_lis(@Param("inhosno")String inhosno, @Param("EndDate")String EndDate, @Param("StartDate")String StartDate, @Param("orgcode")String orgCode);

    List<Map> queryMsLabInfo_zy_lis(@Param("map")Map<String, String> map);
}
