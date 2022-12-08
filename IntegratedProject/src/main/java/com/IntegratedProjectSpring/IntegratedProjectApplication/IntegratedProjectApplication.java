package com.IntegratedProjectSpring.IntegratedProjectApplication;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegratedProjectApplication {
	private static final Logger logger = Logger.getLogger(IntegratedProjectApplication.class);
	public static void main(String[] args) {
		logger.info("IntegratedProjectApplication starting");
		SpringApplication.run(IntegratedProjectApplication.class, args);
	}

}
