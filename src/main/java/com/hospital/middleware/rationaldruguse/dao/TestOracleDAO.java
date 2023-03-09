package com.hospital.middleware.rationaldruguse.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TestOracleDAO {

    Map queryCurrentDateTime();

}
