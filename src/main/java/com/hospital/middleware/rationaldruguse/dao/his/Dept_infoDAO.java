package com.hospital.middleware.rationaldruguse.dao.his;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface Dept_infoDAO {
    List<Map> queryDept_info (@Param("map") Map paramMap);

}
