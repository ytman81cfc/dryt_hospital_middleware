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

         /*ConfigurableApplicationContext cac = SpringApplication.run(HmApplication.class, args);
        HpService hp = cac.getBean(HpService.class);
        hp.queryData("2023-12-01", "2023-12-28", "EMR_RCBCJL");
        System.out.println("");*/
        SpringApplication.run(HmApplication.class, args);
    }
}
