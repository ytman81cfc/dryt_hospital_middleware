package com.hospital.middleware;

import com.hospital.middleware.healthplatform.service.HpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@ServletComponentScan
@SpringBootApplication
public class HmApplication {
    public static void main(String[] args) {
        //用于测试
        ConfigurableApplicationContext cac = SpringApplication.run(HmApplication.class, args);
        HpService hpS = cac.getBean(HpService.class);
        hpS.queryData("2023-09-01", "2024-01-27", "BA_SYJBK");

        //SpringApplication.run(HmApplication.class, args);
    }
}