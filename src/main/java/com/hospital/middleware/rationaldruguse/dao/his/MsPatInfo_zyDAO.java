package com.hospital.middleware.rationaldruguse.dao.his;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.ManagedBean;
import java.util.List;
import java.util.Map;

@Mapper
public interface MsPatInfo_zyDAO {
    List<Map> queryMsPatInfo_zy (@Param("map") Map paramMap);

}
