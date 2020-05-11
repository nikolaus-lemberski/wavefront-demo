# Wavefront Demo

Simple Spring Boot application to demo app monitoring via Tanzu Observability aka Wavefront.

## How to start

1. Build project with Maven and run the project
2. Wavefront lib creates automatically a temporary account for you. Account information is printed to console log.
3. Copy the API key to `application.properties` and uncomment the line
4. Open the Wavefront URL (also included in the console log)

## Create some load

You can call the endpoints (see DemoController.java) manually, or you can run a simple load test with artillery.

```
npm install -g artillery
artillery run loadtest.yml
```
