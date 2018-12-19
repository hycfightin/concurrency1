package com.mmall.concurrency.cp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.mmall.concurrency.cp")
@EntityScan(basePackages = "com.mmall.concurrency.cp")
public class ApplicationCapter5 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationCapter5.class,args);
    }
}
