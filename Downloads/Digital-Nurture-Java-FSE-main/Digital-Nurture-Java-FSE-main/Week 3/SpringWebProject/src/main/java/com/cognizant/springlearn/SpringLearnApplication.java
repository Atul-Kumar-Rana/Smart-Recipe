package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("SpringLearnApplication main() method called");
        LOGGER.trace("This is a TRACE level message");
        LOGGER.debug("This is a DEBUG level message");
        LOGGER.info("This is an INFO level message");
        LOGGER.warn("This is a WARN level message");
        LOGGER.error("This is an ERROR level message");
    }
}
