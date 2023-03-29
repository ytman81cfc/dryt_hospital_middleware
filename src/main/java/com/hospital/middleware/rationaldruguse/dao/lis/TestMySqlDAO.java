package com.hospital.middleware.rationaldruguse.dao.lis;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TestMySqlDAO {
    List<Map> queryCurrentDateTime();
}
