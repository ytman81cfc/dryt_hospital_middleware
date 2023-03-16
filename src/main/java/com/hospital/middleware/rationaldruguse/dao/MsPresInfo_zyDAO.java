package com.hospital.middleware.rationaldruguse.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MsPresInfo_zyDAO {
    List<Map> queryMsPresInfo_zy (@Param("map") Map paramMap);

}
