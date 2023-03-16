package com.hospital.middleware.rationaldruguse.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.ManagedBean;
import java.util.List;
import java.util.Map;

@Mapper
public interface MsPresInfo_mzDAO {
    List<Map> queryMsPresInfo_mz (@Param("map") Map paramMap);

}
