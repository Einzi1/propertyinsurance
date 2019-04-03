#!/bin/bash
mvn package
/usr/lib/jvm/jdk-11.0.2/bin/java -jar target/propertyinsurance-0.0.1-SNAPSHOT.jar
