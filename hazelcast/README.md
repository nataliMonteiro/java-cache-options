# Hazelcast POC with Spring Boot

## Prerequisites
Before you can run this project, you need to ensure that you have the following installed:

* Java JDK 17 or later
* Maven 3.6 or later

## Setting Up
To set up the project, follow these steps:

1. Clone the Repository

````
brew tap hazelcast/hz
brew install hazelcast
````

````
hz start
````

## Build the Project
````
mvn clean install
````

## Running the Application
To run the application, execute the following command from the root directory of the project:

````
mvn spring-boot:run
````
