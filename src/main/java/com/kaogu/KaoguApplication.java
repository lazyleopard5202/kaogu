package com.kaogu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class KaoguApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaoguApplication.class, args);
    }

}
