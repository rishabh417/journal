package com.rishabh.journal.service;

import com.rishabh.journal.apiresponse.WeatherResponse;
import com.rishabh.journal.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

//    private static final String apiKey = "4269b91260858cdd74f2a8eabbcfef7d";
    @Value("${Weather.api.key}")
    private String apiKey;

//    private static final String API = "https://api.weatherstack.com/current?access_key=<apiKey>&query=<city>";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;


    public WeatherResponse getWeather(String city){
        String finalApi = appCache.APP_CACHE.get("weather_api").replace("<apiKey>", apiKey).replace("<city>", city);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET,null, WeatherResponse.class);
        return response.getBody();
    }
}
