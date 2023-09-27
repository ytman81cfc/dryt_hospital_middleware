package com.hospital.middleware.medicalrecord.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MrWebServer {
    @WebMethod
    public String QryMedCardListByOutDate(String startdt, String enddt);
    @WebMethod
    public String QryMedCardListByPatNo(String patNo);
    @WebMethod
    public String GetMedCardXml(String relprimary);
}
