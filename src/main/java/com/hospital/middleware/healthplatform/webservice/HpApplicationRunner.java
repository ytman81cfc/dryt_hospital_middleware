package com.hospital.middleware.healthplatform.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import javax.xml.ws.Endpoint;

@Component
public class HpApplicationRunner implements ApplicationRunner {
    @Autowired
    HpWebServer hpWebServer;
    @Value("${hpWebservice.path}")
    private String path;
    private Logger log = LoggerFactory.getLogger(HpApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("莱州卫健服务发布地址:" + path);
        Endpoint.publish(path, hpWebServer);
        log.info("莱州卫健服务发布成功, 地址:" + path);
    }
}
