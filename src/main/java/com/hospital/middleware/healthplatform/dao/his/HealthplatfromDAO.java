package com.hospital.middleware.healthplatform.dao.his;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HealthplatfromDAO {
    List<Map> queryJbyhryxxb(String orgcode);
    List<Map> queryJbksxxb(String orgcode);
    List<Map> queryJbbqxxb(String orgcode);
    List<Map> queryJbxmml(String orgcode);
    List<Map> queryJbclml(String orgcode);
    List<Map> queryJbzdml(String orgcode);
    List<Map> queryJbssml(String orgcode);
    List<Map> queryYpjbxxk(String orgcode);
    List<Map> queryJbbrjbxxb(String orgcode,String begtime,String endtime);
    List<Map> queryMzghb(String orgcode,String begtime,String endtime);
}