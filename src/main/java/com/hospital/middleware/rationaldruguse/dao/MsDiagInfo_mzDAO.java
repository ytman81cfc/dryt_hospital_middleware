package com.hospital.middleware.rationaldruguse.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MsDiagInfo_mzDAO {
    List<Map> queryMsDiagInfo_mz (@Param("map") Map paramMap);

}
