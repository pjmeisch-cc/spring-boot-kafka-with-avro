a simple project to show how to use the confluent schema registry together with spring-boot-kafka.

# confluent platform

For this test project I use the [Confuent Open Source](https://www.confluent.io/download/) platform.
After downloading and unpacking I start (on macOS) the required components (Zookeepe, Kafka, Schema Registry etc) with:

    bin/confluent start
    
# building and running the program

    mvn spring-boot:run
    
is all what is needed. It starts up the program, sets up a KafkaListener, produces the configured number of records 
into Kafka, consumes them and then shuts down the Listener and so ends the program.

sample run:

```
        XXXX                      _                     _
             X                   | |                   | |
    XXXXXXX   X      ___ ___   __| | ___  ___ ___ _ __ | |_ _ __ _  ___
   X       X  X     / __/ _ \ / _` |/ _ \/ __/ _ \ '_ \| __| '__| |/ __|
  X   XXXXX   X    | (_| (_) | (_| |  __/ (_|  __/ | | | |_| |  | | (__
  X  X       X      \___\___/ \__,_|\___|\___\___|_| |_|\__|_|  |_|\___|
  X   XXXXXXX
   X               Spring Boot (v2.0.2.RELEASE)
    XXXX

2018-05-31 16:44:28.116  INFO 23684 --- [           main] d.c.sbkaavro.SbkaavroApplication         : Starting SbkaavroApplication on gandalf.local with PID 23684 (/Users/peter/Entwicklung/Projekte/spring-boot-kafka-with-avro/target/classes started by peter in /Users/peter/Entwicklung/Projekte/spring-boot-kafka-with-avro)
2018-05-31 16:44:28.121 DEBUG 23684 --- [           main] d.c.sbkaavro.SbkaavroApplication         : Running with Spring Boot v2.0.2.RELEASE, Spring v5.0.6.RELEASE
2018-05-31 16:44:28.122  INFO 23684 --- [           main] d.c.sbkaavro.SbkaavroApplication         : No active profile set, falling back to default profiles: default
2018-05-31 16:44:29.691  INFO 23684 --- [           main] d.c.sbkaavro.SbkaavroApplication         : Started SbkaavroApplication in 1.835 seconds (JVM running for 4.88)
2018-05-31 16:44:29.782  INFO 23684 --- [           main] de.codecentric.sbkaavro.DataProducer     : producing {"lastName": "Cornelius", "firstName": "Burkardt"}, {"zip": "00517", "city": "Bostel", "street": "Dolmanstraße", "streetNumber": "29"}
2018-05-31 16:44:29.831  WARN 23684 --- [           main] o.a.k.clients.producer.ProducerConfig    : The configuration 'specific.avro.reader' was supplied but isn't a known config.
2018-05-31 16:44:29.973  INFO 23684 --- [           main] de.codecentric.sbkaavro.DataProducer     : producing {"lastName": "Häußler", "firstName": "Tilo"}, {"zip": "11325", "city": "Ringe Neugnadenfeld", "street": "Eiching", "streetNumber": "124"}
2018-05-31 16:44:29.999  INFO 23684 --- [ntainer#0-0-C-1] de.codecentric.sbkaavro.DataConsumer     : consuming {"lastName": "Cornelius", "firstName": "Burkardt"}, {"zip": "00517", "city": "Bostel", "street": "Dolmanstraße", "streetNumber": "29"}, remaining 4
2018-05-31 16:44:30.002  INFO 23684 --- [ntainer#0-0-C-1] de.codecentric.sbkaavro.DataConsumer     : consuming {"lastName": "Häußler", "firstName": "Tilo"}, {"zip": "11325", "city": "Ringe Neugnadenfeld", "street": "Eiching", "streetNumber": "124"}, remaining 3
2018-05-31 16:44:30.003  INFO 23684 --- [           main] de.codecentric.sbkaavro.DataProducer     : producing {"lastName": "Krauss", "firstName": "Britt"}, {"zip": "67494", "city": "Altendiez", "street": "Laubanger", "streetNumber": "45"}
2018-05-31 16:44:30.006  INFO 23684 --- [ntainer#0-0-C-1] de.codecentric.sbkaavro.DataConsumer     : consuming {"lastName": "Krauss", "firstName": "Britt"}, {"zip": "67494", "city": "Altendiez", "street": "Laubanger", "streetNumber": "45"}, remaining 2
2018-05-31 16:44:30.007  INFO 23684 --- [           main] de.codecentric.sbkaavro.DataProducer     : producing {"lastName": "Schuster", "firstName": "Notburga"}, {"zip": "37213", "city": "Jameln", "street": "Plärrer", "streetNumber": "5"}
2018-05-31 16:44:30.011  INFO 23684 --- [ntainer#0-0-C-1] de.codecentric.sbkaavro.DataConsumer     : consuming {"lastName": "Schuster", "firstName": "Notburga"}, {"zip": "37213", "city": "Jameln", "street": "Plärrer", "streetNumber": "5"}, remaining 1
2018-05-31 16:44:30.012  INFO 23684 --- [           main] de.codecentric.sbkaavro.DataProducer     : producing {"lastName": "Bacher", "firstName": "Friedegard"}, {"zip": "50232", "city": "Flintsbach am Inn", "street": "Zedernholzweg", "streetNumber": "58"}
2018-05-31 16:44:30.017  INFO 23684 --- [ntainer#0-0-C-1] de.codecentric.sbkaavro.DataConsumer     : consuming {"lastName": "Bacher", "firstName": "Friedegard"}, {"zip": "50232", "city": "Flintsbach am Inn", "street": "Zedernholzweg", "streetNumber": "58"}, remaining 0
```
