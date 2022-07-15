package com.example.demo.view.controllers;

import com.example.demo.view.weatherData.WeatherRequest;
import com.example.demo.domain.weather.WeatherService;
import com.example.demo.view.mappers.WeatherViewMapper;
import com.example.demo.view.weatherData.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    private final WeatherViewMapper weatherMapper;

    @Autowired
    WeatherController(WeatherService weatherService, WeatherViewMapper weatherMapper, WeatherRequest inputParams) {
        this.weatherService = weatherService;
        this.weatherMapper = weatherMapper;
    }

    @PostMapping("/weather")
    String getWeather(@RequestBody WeatherRequest weatherRequest) {
        try {
            WeatherResponse weatherResponse = weatherService.getWeather(weatherRequest);
            return weatherResponse.toString();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
