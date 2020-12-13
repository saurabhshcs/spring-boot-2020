package com.techsharezone.bootifykafka.controller;

/*
 * @created 13/12/2020 -21:10
 * @project bootify-kafka
 * @author  saurabhshcs
 */

import com.techsharezone.bootifykafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KafkaProducerAppController {

    @Autowired
    private KafkaProducerService producerService;

    @GetMapping(value = "/kafka/producer")
    public String producer(@RequestParam("message") String message) {
        producerService.send(message);

        return "Publish messageg [ "+ message+" ] into the kafka successfully.";
    }

}
