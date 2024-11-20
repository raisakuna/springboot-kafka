## Start Zookeepeer
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
## Start Kafka-Server
.\bin\windows\kafka-server-start.bat .\config\server.properties
## Create topics employees with 3 partitiions
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic employees --partitions 3
## Consuming data that is pushed 
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic employees --property print.key=true --property  print.value=true --property print.partition=true --property print.offset=true
