package com.hospital.middleware.hospitalinfection.dao.his;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface JP005DAO {
    List<Map> queryData(@Param("map")Map paramMap);
}
