package com.hospital.middleware.hospitalinfection.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HosInfWebServer {
    @WebMethod
    public String acceptMessage(String message);
}
