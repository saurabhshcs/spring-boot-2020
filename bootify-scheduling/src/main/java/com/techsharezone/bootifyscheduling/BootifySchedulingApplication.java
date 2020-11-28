package com.techsharezone.bootifyscheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling //enabled scheduling for spring boot application
public class BootifySchedulingApplication {

    private static final Logger LOG = LoggerFactory.getLogger(BootifySchedulingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BootifySchedulingApplication.class, args);
    }

    /*
    * This is a very simple example of create a schedule and run a job with 2 seconds of delay
    * This method is annotated with the @Scheduler annotation hence this method will be considered
    * as a scheduler for this microservice
    *
    * fixedRate : Execute the annotated method with a fixed period in milliseconds between invocations.
     * */
    @Scheduled(fixedRate = 2000L)
    private void jobExampleFixedRate() {
    	LOG.info("jobExampleFixedRate: Current timestamp of the job: {} ", new Date());
    }

    /*
     * fixedRate: Execute the annotated method with a fixed period in milliseconds between the end of
     *  the last invocation and the start of the next.
     * */
    @Scheduled(fixedDelay = 2000L)
    private void jobExampleFixedDelay() {
        LOG.info("jobExampleFixedDelay: Current timestamp of the job: {} ", new Date());
    }

    /*
     * fixedRate: Execute the annotated method with a fixed period in milliseconds between the end of
     *  the last invocation and the start of the next.
     *
     * initialDelay: Number of milliseconds to delay before the first execution of a fixedRate or fixedDelay task.
     * */
    @Scheduled(fixedDelay = 2000L, initialDelay = 2000L)
    private void jobExampleInitialDelay() {
        LOG.info("jobExampleInitialDelay: Current timestamp of the job: {} ", new Date());
    }

    /*
     * fixedRate: Execute the annotated method with a fixed period in milliseconds between the end of
     *  the last invocation and the start of the next.
     *
     * initialDelay: Number of milliseconds to delay before the first execution of a fixedRate or fixedDelay task.
     * P: Pre-define designator of duration of the period
     * T: Time Period then we can define time in seconds, minutes, hours
     * in below example I used 2S for 2 seconds.
     * There is following list of Java Duration
     *  Duration of 2 Nanos : PT0.000000002S
     *  Duration of 2 Micros : PT0.000002S
     *  Duration of 2 Millis : PT0.002S
     *  Duration of 2 Seconds : PT2S
     *  Duration of 2 Minutes : PT2M
     *  Duration of 2 Hours : PT2H
     *  Duration of 2 HalfDays : PT24H
     *  Duration of 2 Days : PT48H
     *  Duration of unit Weeks not supported
     *  Duration of unit Months not supported
     *  Duration of unit Years not supported
     *  Duration of unit Decades not supported
     *  Duration of unit Centuries not supported
     *  Duration of unit Millennia not supported
     *  Duration of unit Eras not supported
     *  Duration of unit Forever not supported
     *
     * */
    @Scheduled(fixedDelayString = "PT2S", initialDelay = 2000L)
    private void jobExampleFixedDelayString() {
        LOG.info("jobExampleFixedDelayString: Current timestamp of the job: {} ", new Date());
    }

    /*
    * --------------------------------------------------------------------------------------------------------------------
    * Find cron configuration - https://crontab.guru/
    * Running example based on sample cron as At minute 1 on day-of-month 2 and on Monday.
    * 1 * 2 * 1
    * --------------------------------------------------------------------------------------------------------------------
    * You can test this cron is running successfully by adding 1/2 * * * * it is set for every 2 seconds
    * A cron-like expression, extending the usual UN*X definition to include triggers on the second, minute,
    *  hour, day of month, month, and day of week.
    * For example, "0 * * * * MON-FRI" means once per minute on weekdays (at the top of the minute - the 0th second).
    * The fields read from left to right are interpreted as follows.
    * - second
    * - minute
    * - hour
    * - day of month
    * - month
    * - day of week
    *  The special value "-" indicates a disabled cron trigger, primarily meant for externally specified values resolved
    *  by a ${...} placeholder.
    * */
    @Scheduled(cron = "1/2 * * * * *")
    private void jobExampleCron() {
        LOG.info("jobExampleCron: Current timestamp of the job: {} ", new Date());
    }


}
