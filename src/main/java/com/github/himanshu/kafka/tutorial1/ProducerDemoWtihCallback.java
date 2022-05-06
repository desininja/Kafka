package com.github.himanshu.kafka.tutorial1;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemoWtihCallback {

    public static void main(String[] args) {

        //String bootstrapServers = "localhost:9092";


        //create Producer properties
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the producer
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);


        // Create a producer record

        ProducerRecord<String,String> record =
                new ProducerRecord<String,String>("first-topic","Hello World!");
        // send the data

        producer.send(record);
        producer.flush();
        producer.close();
    }
}
