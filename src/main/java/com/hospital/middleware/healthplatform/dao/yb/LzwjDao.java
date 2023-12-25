package com.hospital.middleware.healthplatform.dao.yb;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LzwjDao {
    public void deleteJB_CLML(Map<String, String> map);
    public void insertJB_CLML(Map<String, String> map);

    public void deleteJB_XMML(Map<String, String> map);
    public void insertJB_XMML(Map<String, String> map);

    public void deleteJBBQXXB(Map<String, String> map);
    public void insertJBBQXXB(Map<String, String> map);

    public void deleteJBKSXXB(Map<String, String> map);
    public void insertJBKSXXB(Map<String, String> map);

    public void deleteJBYHRYXXB(Map<String, String> map);
    public void insertJBYHRYXXB(Map<String, String> map);

    public void deleteJB_ZDML(Map<String, String> map);
    public void insertJB_ZDML(Map<String, String> map);

    public void deleteJB_SSML(Map<String, String> map);
    public void insertJB_SSML(Map<String, String> map);

    public void deleteYP_JBXXK(Map<String, String> map);
    public void insertYP_JBXXK(Map<String, String> map);

    public void deleteJBBRJBXXB(Map<String, String> map);
    public void deleteJBBRJBXXBByPk(Map<String, String> map);
    public void insertJBBRJBXXB(Map<String, String> map);

    public void deleteMZGHB(Map<String, String> map);
    public void insertMZGHB(Map<String, String> map);

    public void deleteMZJZJLB(Map<String, String> map);
    public void insertMZJZJLB(Map<String, String> map);

    public void deleteMZYZMXB(Map<String, String> map);
    public void insertMZYZMXB(Map<String, String> map);

    public void deleteMZSFJLB(Map<String, String> map);
    public void deleteMZSFJLBByPk(Map<String, String> map);
    public void insertMZSFJLB(Map<String, String> map);

    public void deleteMZSFMXB(Map<String, String> map);
    public void insertMZSFMXB(Map<String, String> map);

    public void deleteMZFYJSXX(Map<String, String> map);
    public void deleteMZFYJSXXByPk(Map<String, String> map);
    public void insertMZFYJSXX(Map<String, String> map);

    public void deleteZYJZJLB(Map<String, String> map);
    public void deleteZYJZJLBByPk(Map<String, String> map);
    public void insertZYJZJLB(Map<String, String> map);

    public void deleteZYYZMXB(Map<String, String> map);
    public void deleteZYYZMXBByPk(Map<String, String> map);
    public void insertZYYZMXB(Map<String, String> map);

    public void deleteZYSFJLB(Map<String, String> map);
    public void insertZYSFJLB(Map<String, String> map);

    public void deleteZYSFMXB(Map<String, String> map);
    public void insertZYSFMXB(Map<String, String> map);

    public void deleteZYCYXJBG(Map<String, String> map);
    public void insertZYCYXJBG(Map<String, String> map);

    public void deleteZYRYDJB(Map<String, String> map);
    public void insertZYRYDJB(Map<String, String> map);

    public void deleteZYCYDJB(Map<String, String> map);
    public void insertZYCYDJB(Map<String, String> map);

    public void deleteZYYJJ(Map<String, String> map);
    public void insertZYYJJ(Map<String, String> map);

    public void deleteZYFYFSMX(Map<String, String> map);
    public void insertZYFYFSMX(Map<String, String> map);

    public void  deleteBA_SYJBKByPK(Map<String, String> map);
    public void  insertBA_SYJBK(Map<String, String> map);

    public void deleteBA_SYSSK(Map<String, String> map);
    public void insertBA_SYSSK(Map<String, String> map);

    public void deleteBA_SYZDKByPk(Map<String, String> map);
    public void insertBA_SYZDK(Map<String, String> map);

    public void deleteZYZDMXBG(Map<String, String> map);
    public void insertZYZDMXBG(Map<String, String> map);

    public void deleteJYJLBByPk(Map<String, String> map);
    public void insertJYJLB(Map<String, String> map);

    public void deleteJYMXBByPk(Map<String, String> map);
    public void insertJYMXB(Map<String, String> map);

    public void deleteJYSFXMBByPk(Map<String, String> map);
    public void insertJYSFXMB(Map<String, String> map);

    public void deleteJCJLBByPk(Map<String, String> map);
    public void insertJCJLB(Map<String, String> map);

    public void deleteJCJLZBByPK(Map<String, String> map);
    public void insertJCJLZB(Map<String, String> map);

    public void deleteEMR_MJZBL(Map<String, String> map);
    public void insertEMR_MJZBL(Map<String, String> map);

    public void deleteEMR_RYJLByPk(Map<String, String> map);
    public void insertEMR_RYJL(Map<String, String> map);

    public void deleteEMR_CRYJLByPk(Map<String, String> map);
    public void insertEMR_CRYJL(Map<String, String> map);

    public void deleteEMR_ZYSWJLByPk(Map<String, String> map);
    public void insertEMR_ZYSWJL(Map<String, String> map);

    public void deleteTJ_MJZ_RBByPK(Map<String, String> map);
    public void insertTJ_MJZ_RB(Map<String, String> map);

    public void deleteTJ_ZY_RBByPK(Map<String, String> map);
    public void insertTJ_ZY_RB(Map<String, String> map);

    public void deleteTJ_ZYGZL_KS_RBByPK(Map<String, String> map);
    public void insertTJ_ZYGZL_KS_RB(Map<String, String> map);

    public void deleteTJ_SSYW_CWZYQKByPK(Map<String, String> map);
    public void insertTJ_SSYW_CWZYQK(Map<String, String> map);

    public void deleteEMR_SCBCJLByPK(Map<String, String> map);
    public void insertEMR_SCBCJL(Map<String, String> map);

    public void deleteEMR_RCBCJLByPK(Map<String, String> map);
    public void insertEMR_RCBCJL(Map<String, String> map);
}