package com.hospital.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class HmApplication {
    public static void main(String[] args) {
        SpringApplication.run(HmApplication.class, args);
    }
}
