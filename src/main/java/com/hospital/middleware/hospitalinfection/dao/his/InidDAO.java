package com.hospital.middleware.hospitalinfection.dao.his;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface InidDAO {
    Map selectInid(@Param("map")Map paramMap);

    Map selectRegid(@Param("map")Map paramMap);
}
