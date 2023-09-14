package com.hospital.middleware.medicalrecord.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface MedicalrecordDAO {
    Map selectInid(@Param("map")Map paramMap);

}
