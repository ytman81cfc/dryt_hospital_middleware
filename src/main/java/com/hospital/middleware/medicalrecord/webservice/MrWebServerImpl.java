package com.hospital.middleware.medicalrecord.webservice;

import com.hospital.middleware.medicalrecord.service.MRService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.jws.WebService;

@Service
@WebService
public class MrWebServerImpl implements MrWebServer {
    @Autowired
    private MRService mrs;
    private Logger log = LoggerFactory.getLogger(MrWebServerImpl.class);


    @Override
    public String QryMedCardListByOutDate(String startdt, String enddt) {
        return mrs.QryMedCardListByOutDate(startdt, enddt);
    }

    @Override
    public String QryMedCardListByPatNo(String patNo) {
        return mrs.QryMedCardListByPatNo(patNo);
    }

    @Override
    public String GetMedCardXml(String relprimary) {
        return mrs.GetMedCardXml(relprimary);
    }
}
