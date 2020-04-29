# address-service

A CRUD service for addresses, intended as a sample for spring boot CRUD + event propagation service. 

## Architecture
Based on the [CQRS](https://martinfowler.com/bliki/CQRS.html) design pattern, this service only allows creation of addresses, and publish events on a [kafka](https://kafka.apache.org/) topic. It enables other services to consume those events and build up dedicated databases for querying. 

## Running it locally
1. Install Java 12+. I recommend [sdkman](https://sdkman.io/) for it. 
2. On root folder, run `./gradlew bootRun`

