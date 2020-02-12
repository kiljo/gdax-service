package com.kijo.gdaxservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GDAXServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(GDAXServiceApplication.class, args);
  }

}