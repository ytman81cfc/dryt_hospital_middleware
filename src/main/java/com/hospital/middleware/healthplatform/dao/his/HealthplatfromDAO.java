package com.hospital.middleware.healthplatform.dao.his;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HealthplatfromDAO {
    List<Map> queryJbyhryxxb(String orgcode);
    List<Map> queryJbksxxb(String orgcode);
    List<Map> queryJbbqxxb(String orgcode);
    List<Map> queryJb_xmml(String orgcode);
    List<Map> queryJb_clml(String orgcode);
    List<Map> queryJb_zdml(String orgcode);
    List<Map> queryJb_ssml(String orgcode);
    List<Map> queryYp_jbxxk(String orgcode);
    List<Map> queryJbbrjbxxb(String orgcode,String begtime,String endtime);
    List<Map> queryMzghb(String orgcode,String begtime,String endtime);
    List<Map> queryMzthb(String orgcode,String begtime,String endtime);
    List<Map> queryMzjzjlb(String orgcode,String begtime,String endtime);
    List<Map> queryMzyzmxb(String orgcode,String begtime,String endtime);
    List<Map> queryMzsfjlbsf(String orgcode,String begtime,String endtime);
    List<Map> queryMzsfjlbtf(String orgcode,String begtime,String endtime);
    List<Map> queryMzsfmxbsf(String orgcode,String begtime,String endtime);
    List<Map> queryMzsfmxbtf(String orgcode,String begtime,String endtime);
    List<Map> queryMzsfjsxx(String orgcode,String begtime,String endtime);
    List<Map> queryZyjzjlb(String orgcode,String begtime,String endtime);
    List<Map> queryZyyzmxb(String orgcode,String begtime,String endtime);


}