package com.restapi.restapi.api;

import com.restapi.restapi.config.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WeatherController {

    @RequestMapping(method = RequestMethod.GET, value = "/byCity/{country}/{city}")
    public @ResponseBody Object getWeatherByCity(@PathVariable String city, @PathVariable String country) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Object> response = restTemplate.
                getForEntity("https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country +
                        "&APPID=80730ceb55c51bebae397cfc46e03344",
                Object.class);

        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/forecastByCity/{country}/{city}")
    public @ResponseBody Object getForecastByCity(@PathVariable String city, @PathVariable String code) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Object> response = restTemplate.
                getForEntity("https://api.openweathermap.org/data/2.5/forecast?q=" + city + "," + code +
                                "&APPID=" + Configuration.API_KEY,
                        Object.class);

        return response;
    }

}


