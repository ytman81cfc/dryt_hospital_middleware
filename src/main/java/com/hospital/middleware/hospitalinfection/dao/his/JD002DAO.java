package com.hospital.middleware.hospitalinfection.dao.his;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface JD002DAO {
    List<Map> queryData(@Param("map")Map paramMap);
}
