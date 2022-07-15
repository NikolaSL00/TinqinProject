package com.example.demo.view.mappers;


import com.example.demo.data.models.entities.Type;
import com.example.demo.domain.models.Weather;
import com.example.demo.view.weatherData.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class WeatherViewMapper {

    public WeatherResponse weatherToWeatherResponse(Weather weather, Type type){
        return WeatherResponse.builder()
                .town(weather.getLocation())
                .type(type.getLabel())
                .temperature(weather.getTemperature())
                .humidity(weather.getHumidity())
                .wind(weather.getWind())
                .conditon(weather.getConditon())
                .build();
    }
}
