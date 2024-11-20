## Start Zookeepeer
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
## Start Kafka-Server
.\bin\windows\kafka-server-start.bat .\config\server.properties
## Create topics employees with 3 partitiions
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic employees --partitions 3
