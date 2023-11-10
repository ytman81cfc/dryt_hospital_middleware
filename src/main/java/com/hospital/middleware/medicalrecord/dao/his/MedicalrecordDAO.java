package com.hospital.middleware.medicalrecord.dao.his;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MedicalrecordDAO {
    List<Map<String, String>> queryMedcard(String orgcode,String inid);
    List<Map<String, String>> queryIcde(String orgcode,String inid);
    List<Map<String, String>> queryOper(String orgcode,String inid);
    List<Map> qryMedCardListByPatNo(Map param);
    List<Map> qryMedCardListByOutDate(Map param);
}