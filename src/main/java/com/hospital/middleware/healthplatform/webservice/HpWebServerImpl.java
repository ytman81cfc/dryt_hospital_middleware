package com.hospital.middleware.healthplatform.webservice;

import com.hospital.middleware.healthplatform.service.HpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.jws.WebService;

@Service
@WebService
public class HpWebServerImpl implements HpWebServer {

    @Autowired
    private HpService hps;
    private Logger log = LoggerFactory.getLogger(HpWebServerImpl.class);

    @Override
    public String queryData(String startdt, String enddt, String dataType){
        return hps.queryData(startdt, enddt, dataType);
    }

}
