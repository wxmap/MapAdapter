package com.gis.MapAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MapAdapterApplication {
	static Logger logger= LoggerFactory.getLogger(MapAdapterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MapAdapterApplication.class, args);
		System.out.println("start:8080 111");
		logger.error("sssssss");
	}

}
