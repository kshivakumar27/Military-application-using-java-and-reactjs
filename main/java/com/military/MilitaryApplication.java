 package com.military;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
 
@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
//@CrossOrigin(origins = "http://172.19.1.101:4200")
   
@CrossOrigin(origins = "http://172.19.1.84:4200")
public class MilitaryApplication  extends SpringBootServletInitializer {
	 @Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(MilitaryApplication.class);
	   }
	   public static void main(String[] args) {
	      SpringApplication.run(MilitaryApplication.class, args);
	   }
}
 