package de.codecentric.sbkaavro;

import de.codecentric.sbkaavro.avro.Address;
import de.codecentric.sbkaavro.avro.Person;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DataConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataConsumer.class);

    @KafkaListener(topics = {"${de.codecentric.sbkaavro.topic}"})
    public void receive(ConsumerRecord<Person, Address> consumerRecord) {
        Person person = consumerRecord.key();
        Address address = consumerRecord.value();
        LOGGER.info("consuming {}, {}", person, address);
    }
}
