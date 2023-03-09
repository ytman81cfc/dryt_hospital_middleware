package com.hospital.middleware.hospitalinfection.webservice;

import javax.jws.WebService;
import java.util.Map;

import com.hospital.middleware.hospitalinfection.service.ServiceFactory;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@WebService
public class HosInfWebServerImpl implements HosInfWebServer {
    @Autowired
    private ServiceFactory sf;

    @Override
    public String acceptMessage(String message) {
        System.out.println("传入的参数(XML):\n" + message);
        JSONObject json = XML.toJSONObject(message);
        String jsonString = json.toString();
        System.out.println("传入的参数(JSON):\n" +jsonString);
        Map param = (Map) json.toMap();
        String xmlResult = sf.getXMLData(param);


        return xmlResult;
    }
}
