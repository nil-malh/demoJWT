package fr.nil.demojwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJwtApplication {
   private static final Logger logger = LoggerFactory.getLogger(DemoJwtApplication.class);
    public static void main(String[] args) {
        logger.warn("WARNING, THE SECRET KEY IN JWTService.class IS NOT TO BE USED IN PRODUCTION");
        SpringApplication.run(DemoJwtApplication.class, args);
    }

}
