package com.hospital.middleware.hospitalinfection.dao.lis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface JP022DAO {
    List<Map> queryData(@Param("orgcode")String orgcode,@Param("inhosno")String inhosno,@Param("StartDate")String StartDate,@Param("EndDate")String EndDate);

}
