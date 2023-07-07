package com.hospital.middleware.emr.dao.his;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmrDAO {
    List<Map> queryBaza (@Param("map") Map paramMap);
    List<Map> queryBaf1 (@Param("map") Map paramMap);
    List<Map> queryBaf4 (@Param("map") Map paramMap);
    List<Map> queryBaf6 (@Param("map") Map paramMap);
    List<Map> queryTjz1 (@Param("map") Map paramMap);
}
