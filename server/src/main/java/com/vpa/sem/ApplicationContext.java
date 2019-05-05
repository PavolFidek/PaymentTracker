package com.vpa.sem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.vpa.sem.payment", "com.vpa.sem.user", "com.vpa.sem"})
public class ApplicationContext {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationContext.class, args);
    }
}
