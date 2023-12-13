package com.hospital.middleware.rationaldruguse.dao.his;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MsLabInfo_zy_hisDAO {

    void deleteAll(@Param("map")Map<String, String> map);
    void updateAll(@Param("map")Map<String, String> map);
    void add(@Param("map")Map<String, String> map);
    List<Map> queryMsLabInfo_zy_his(@Param("map")Map<String, String> map);

}
