package com.hospital.middleware.rationaldruguse.controller;

import com.hospital.middleware.rationaldruguse.dao.TestOracleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.Map;

@RestController
@RequestMapping("/rationaldruguse/testhttp")
public class TestHttp {

    @Autowired
    private TestOracleDAO testOracleDAO;


    @RequestMapping("testHttp01")
    public String testHttp01(){
        return "testHttp01";
    }

    @RequestMapping("testHttp02")
    public Hashtable<Object, Object> testHttp02(){
        Hashtable<Object, Object> ht = new Hashtable<Object, Object>();
        ht.put("ht", "testHttp02");
        return ht;
    }

    @RequestMapping("queryCurrentDateTime")
    public Map<Object, Object> queryCurrentDateTime(){
        return testOracleDAO.queryCurrentDateTime();
    }


}
