package com.techsharezone.bootifyscheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class BootifySchedulingApplication {

    private static final Logger LOG = LoggerFactory.getLogger(BootifySchedulingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BootifySchedulingApplication.class, args);
    }

    @Scheduled(fixedRate = 2000L)
    private void job() {
    	LOG.info("Current timestamp of the job: {} ", new Date());
    }
}
