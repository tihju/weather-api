package com.restapi.restapi.api;

import com.restapi.restapi.config.Configuration;
import com.restapi.restapi.model.Location;
import com.restapi.restapi.model.OpenWeatherResponse;
import com.restapi.restapi.model.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class WeatherController {
//	@Autowired
//	private Weather weather;
//	
//	@Autowired
//	private OpenWeatherResponse openWeatherResponse;
	private List<Weather> weathers= new ArrayList<Weather>();
	
    @RequestMapping(value="", method= RequestMethod.GET)
    public String weather (ModelMap model) {
        Location location = new Location();

        model.put("location", location);
        return "weather";
    }
    
    @RequestMapping(value="", method=RequestMethod.POST)
    public String weatherPost (@ModelAttribute Location location, ModelMap model) throws URISyntaxException, UnsupportedEncodingException {

        String apiKey="9d70ec4175aaa312ffc8b5b659dd91f8";

        RestTemplate template = new RestTemplate();

        // Construct a URI object
        // Encode city name to prevent spaces
        URI uri = new URI("http://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(location.getCity(), "UTF-8") + "," + location.getCountryCode() + "&units=imperial&appid=" + apiKey);

        // Create a request with Get method and the generated uri
        RequestEntity<String> request = new RequestEntity<String>(HttpMethod.GET, uri);

        // Create a response with WeatherResponse type to only store the info we need from the API response
        ResponseEntity<OpenWeatherResponse> weatherResponse = template.exchange(uri, HttpMethod.GET, request, OpenWeatherResponse.class);
        weathers = weatherResponse.getBody().getWeather();
        String message = "no advice for now";
        for(int i = 0; i < weathers.size(); i++) {
        	if(weathers.get(i).getMain().indexOf("Rain") > -1) {
        		message = "Bring raincoad!";
        	}
        	if(weathers.get(i).getMain().indexOf("Clouds") > -1) {
        		message = "Cloudy outside! drive save!";
        	}
        	
        }
        
        // Empty the form fields
        location = new Location();
        model.put("location", location);

        // Get body of the response entity
        model.put("weatherResponse", weatherResponse.getBody());
        
        model.addAttribute("message", message);
      

        return "weather";
    }
    
    

/*    @RequestMapping(method = RequestMethod.GET, value = "/byCity/{country}/{city}")
    public @ResponseBody Object getWeatherByCity(@PathVariable String city, @PathVariable String country) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

//        ResponseEntity<Object> response = restTemplate.
//                getForEntity("https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country +
//                        "&APPID=80730ceb55c51bebae397cfc46e03344",
//                		"&APPID=" + Configuration.API_KEY,
//                Object.class);
        
        ResponseEntity<OpenWeatherResponse> response = restTemplate.
                getForEntity("https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country +
                        "&APPID=80730ceb55c51bebae397cfc46e03344",
                //		"&APPID=" + Configuration.API_KEY,
                OpenWeatherResponse.class);
        
        System.out.println();
        
        

        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/forecastByCity/{country}/{city}")
    public @ResponseBody Object getForecastByCity(@PathVariable String city, @PathVariable String country) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Object> response = restTemplate.
                getForEntity("https://api.openweathermap.org/data/2.5/forecast?q=" + city + "," + country +
                                "&APPID=" + Configuration.API_KEY,
                        Object.class);

        return response;
    }
*/
}


