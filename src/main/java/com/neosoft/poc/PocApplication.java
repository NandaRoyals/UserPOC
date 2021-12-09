package com.neosoft.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
@SpringBootApplication
public class PocApplication {

	 public static void main(String[] args) {
	      SpringApplication springApplication=new SpringApplication(PocApplication.class);
	      System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
	      springApplication.run(args);

	  }

}
