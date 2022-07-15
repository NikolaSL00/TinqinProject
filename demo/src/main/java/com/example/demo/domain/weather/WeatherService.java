package com.example.demo.domain.weather;

import com.example.demo.view.weatherData.WeatherRequest;
import com.example.demo.view.weatherData.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeather(WeatherRequest weatherRequest);
}
