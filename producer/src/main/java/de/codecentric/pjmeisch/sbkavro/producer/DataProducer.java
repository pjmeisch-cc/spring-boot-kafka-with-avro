/*
 * (c) Copyright 2018 sothawo
 */
package de.codecentric.pjmeisch.sbkavro.producer;

import de.codecentric.pjmeisch.sbkavro.avro.Address;
import de.codecentric.pjmeisch.sbkavro.avro.Person;
import io.codearte.jfairy.Fairy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.stream.IntStream;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@Component
public class DataProducer implements ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataProducer.class);

    private final KafkaTemplate<Person, Address> kafka;

    public DataProducer(
            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") KafkaTemplate<Person, Address> kafka) {
        this.kafka = kafka;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final Fairy fairy = Fairy.create(Locale.GERMANY);

        IntStream.rangeClosed(1, 10).boxed()
                .map(i -> fairy.person())
                .forEach(f -> {
                    Person person = Person.newBuilder()
                            .setFirstName(f.getFirstName())
                            .setLastName(f.getLastName())
                            .build();
                    Address address = Address.newBuilder()
                            .setZip(f.getAddress().getPostalCode())
                            .setCity(f.getAddress().getCity())
                            .setStreet(f.getAddress().getStreet())
                            .setStreetNumber(f.getAddress().getStreetNumber())
                            .build();

                    LOGGER.info("producing {}, {}", person, address);

                    kafka.send("persons", person, address);
                });
    }
}
