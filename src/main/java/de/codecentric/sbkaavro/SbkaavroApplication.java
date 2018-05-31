package de.codecentric.sbkaavro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SbkaavroApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbkaavroApplication.class, args);
    }
}
