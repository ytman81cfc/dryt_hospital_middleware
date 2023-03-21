package com.hospital.middleware.rationaldruguse.dao.his;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MsPatInfo_mzDAO {
    List<Map> queryMsPatInfo_mz (@Param("map") Map paramMap);
}
