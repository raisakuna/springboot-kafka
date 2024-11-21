package com.graphica;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaProducerTest {

	public static void main(String[] args) {
		// topic name -> employees
		// Pushing topic to producer
		Properties properties = new Properties();
		
		properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty("bootstrap.servers", "localhost:9092");
		
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
		
		for(int i =0; i<=5; i++) {
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("employees", "John doe" + i);
		kafkaProducer.send(record,new Callback() {

			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
if(exception ==null) {
	System.out.println("topic: " + metadata.topic());
	System.out.println("partition: " + metadata.partition());
	System.out.println("offset: " + metadata.offset());
}
			}
			
		});
		kafkaProducer.flush();
		System.out.println("producer created ..");
	}
		kafkaProducer.close();

	}
}
