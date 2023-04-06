package com.hospital.middleware.hospitalinfection.dao.lis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface JP020DAO {
    List<Map> queryData(@Param("orgcode")String orgcode,@Param("PatientId")String PatientId,@Param("StartDate")String StartDate,@Param("EndDate")String EndDate);

}
