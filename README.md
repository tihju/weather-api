# REST API with Spring

## Usage

1. Clone the repository.
2. Open with your favorite editor. (IntelliJ or Eclipse recommended).
3. Import the maven dependencies. In IntelliJ, enable auto import to do this.
4. In `src/com/restapi/restapi` directory, create a package named `api` and create a static class called `Configuration`.
5. ```java
    package com.restapi.restapi.config;
    
    public class Configuration {
        public static String API_KEY = "";
    }
    ```
6. Obtain a API key from Openweathermap API and add that key to this `API_KEY` variable.
7. Run the Tomcat server.
8. Using a REST client, test the endpoints.