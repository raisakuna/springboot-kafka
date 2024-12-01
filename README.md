# Kafka in local
This Java program demonstrates the use of Kafka's KafkaProducer to send messages asynchronously to a Kafka topic named "employees". It begins by setting up producer configurations, including the broker address (localhost:9092) and serializers for the key and value as strings. A KafkaProducer instance is created, and a loop generates six messages (John doe0 to John doe5) using ProducerRecord, sending each to the topic. The send() method is used with a Callback to handle success or failure of the message delivery, printing metadata like topic, partition, and offset upon successful delivery. The flush() method ensures all buffered messages are sent before the program proceeds, and the producer is gracefully closed to release resources. This approach showcases efficient, asynchronous message production with success tracking for robust Kafka integration.

## Start Zookeepeer Server
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

## Start Kafka-Server /Broker
.\bin\windows\kafka-server-start.bat .\config\server.properties

## Create topics employees with 3 partitiions
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic employees --partitions 3

## list out all topic names

kafka-topics.bat --bootstrap-server localhost:9092 --list

## Describe topics

kafka-topics.bat--bootstrap-server localhost:9092 --describe --topic employees

## Produce message

kafka-console-producer.bat --bootstrap-server localhost:9092 --topic employees


## Consuming data that is pushed 
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic employees --property print.key=true --property  print.value=true --property print.partition=true --property print.offset=true


# Confluent Kafka Community Edition in local
## Start Zookeeper Server

bin/zookeeper-server-start etc/kafka/zookeeper.properties

## Start Kafka Server / Broker

bin/kafka-server-start etc/kafka/server.properties

## Create topic

bin/kafka-topics --bootstrap-server localhost:9092 --create --topic NewTopic1 --partitions 3 --replication-factor 1

## list out all topic names

bin/kafka-topics --bootstrap-server localhost:9092 --list

## Describe topics

bin/kafka-topics --bootstrap-server localhost:9092 --describe --topic NewTopic1

## Produce message

bin/kafka-console-producer --broker-list localhost:9092 --topic NewTopic1

## consume message

bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic NewTopic1 --from-beginning 

## Send CSV File data to kafka

bin/kafka-console-producer --broker-list localhost:9092 --topic NewTopic1 <bin/customers.csv

