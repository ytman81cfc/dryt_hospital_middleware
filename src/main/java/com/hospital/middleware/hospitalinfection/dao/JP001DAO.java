package com.hospital.middleware.hospitalinfection.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface JP001DAO {
    Map queryData();
}
