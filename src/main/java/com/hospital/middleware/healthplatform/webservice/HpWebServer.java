package com.hospital.middleware.healthplatform.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HpWebServer {
    @WebMethod
    public String queryData(String startdt, String enddt, String dataType);
    @WebMethod
    public void insertLog(String begtime, String endtime, String dataType, String begTimeStamp, String endTimeStamp, String message);
}