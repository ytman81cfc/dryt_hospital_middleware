package com.hospital.middleware.hospitalinfection.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface JP006DAO {
    List<Map> queryData();
}
