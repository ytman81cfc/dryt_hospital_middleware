package com.hospital.middleware.healthplatform.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HpWebServer {
    @WebMethod
    public String queryData(String startdt, String enddt, String dataType);
}