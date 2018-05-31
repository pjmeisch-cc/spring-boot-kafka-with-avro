/*
 * (c) Copyright 2018 sothawo
 */
package de.codecentric.pjmeisch.sbkavro.producer;

import de.codecentric.pjmeisch.sbkavro.avro.Address;
import de.codecentric.pjmeisch.sbkavro.avro.Person;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@Component
public class DataConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataConsumer.class);

    @KafkaListener(topics = {"persons"})
    public void receive(ConsumerRecord<Person, Address> consumerRecord) {
        Person person = consumerRecord.key();
        Address address = consumerRecord.value();

        LOGGER.info("consuming {}, {}", person, address);
    }
}
