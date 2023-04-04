package com.hospital.middleware.hospitalinfection.dao.lis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface JD004DAO {
    List<Map> queryData(@Param("map")Map paramMap);
}
