# Weather API Wrapper Service 🌤️

This project is the solution for the [Weather API Wrapper Service](https://roadmap.sh/projects/weather-api-wrapper-service) challenge from roadmap.sh.  
It exposes an endpoint built with **Spring Boot** that consumes the [Visual Crossing Weather API](https://www.visualcrossing.com/) and returns simplified weather information.

## 🚀 Requirements
- Java 17+
- Redis (can be run via Docker)
- Account and API Key from [Visual Crossing](https://www.visualcrossing.com/)

## 📦 Technologies used
- Spring Boot
- Spring Cache with Redis
- RestTemplate (for HTTP requests)

## ⚙️ Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/Gustavodep02/weather-api.git
   cd weather-api
   ```

2. Configure your API key in `application.properties`:
   ```properties
   weather.api.key=YOUR_API_KEY_HERE
   spring.cache.type=redis
   ```

3. Start Redis with Docker:
   ```bash
   docker run --name redis -p 6379:6379 -d redis
   ```

4. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## 🌍 Usage

The endpoint is available at:

```
GET /{location}
```

### Examples:
- By latitude/longitude:
  ```
  GET http://localhost:8080/-23.53,-46.46
  ```

- By country/city:
  ```
  GET http://localhost:8080/Brazil
  ```

### Response:
```text
Weather(address=-23.53, -46.46, description=Similar temperatures continuing with a chance of rain Thursday & Friday., datetime=2025-09-28, temp=17.9)
```

## 🗄️ Cache
Responses are cached in **Redis** using the key `weather::{location}` to avoid unnecessary calls to the external API.
