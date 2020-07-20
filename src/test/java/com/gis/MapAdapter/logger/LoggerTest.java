package com.gis.MapAdapter.logger;


import com.gis.MapAdapter.service.service.HelloService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class LoggerTest {
    Logger logger= LoggerFactory.getLogger(Logger.class);
    @Autowired
    HelloService helloService;
    @Test
    public void loggerTest(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.info(helloService.say());
    }
}
