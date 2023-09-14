package com.hospital.middleware.medicalrecord.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MedicalrecordDAO {
    Map  queryMedcard(String orgcode,String inid  );

    List<Map> queryIcde(String orgcode,String inid );

    List<Map> queryOper(String orgcode,String inid );
}
