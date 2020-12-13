package com.techsharezone.bootifykafka.service;

/*
 * @created 13/12/2020 -21:06
 * @project bootify-kafka
 * @author  saurabhshcs
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "order_placed";

    public void send(final String message){
        kafkaTemplate.send(TOPIC, message);
    }
}
