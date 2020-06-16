package com.jmall.user.registerVerification;

import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import java.util.Map;

public class KafKaRegisterSuccConsumerFactory extends DefaultKafkaConsumerFactory {
    public KafKaRegisterSuccConsumerFactory(Map confings) {
        super(confings);
    }
}
