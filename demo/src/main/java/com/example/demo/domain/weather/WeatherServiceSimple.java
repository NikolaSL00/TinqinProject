package com.example.demo.domain.weather;

import com.example.demo.data.models.entities.Town;
import com.example.demo.data.models.weatherOld.RestApiService;
import com.example.demo.data.repositories.TownRepository;
import com.example.demo.domain.models.Coordinate;
import com.example.demo.domain.models.Weather;
import com.example.demo.view.mappers.WeatherViewMapper;
import com.example.demo.view.weatherData.WeatherRequest;
import com.example.demo.view.weatherData.WeatherResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class WeatherServiceSimple implements WeatherService  {

    private final TownRepository townRepository;
    private final RestApiService restApiService;

    private final WeatherViewMapper weatherViewMapper;

    public WeatherServiceSimple(TownRepository townRepository, RestApiService restApiService, WeatherViewMapper weatherViewMapper) {
        this.townRepository = townRepository;
        this.restApiService = restApiService;
        this.weatherViewMapper = weatherViewMapper;
    }

    @Override
    public WeatherResponse getWeather(WeatherRequest weatherRequest) {
        Optional<Town> town = townRepository
                .findByNameAndCountryName(weatherRequest.getLabel(), weatherRequest.getCountry());

        if(town.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Town or country not found",
                    new Exception("Town or country not found"));
        }

        Coordinate coordinate = new Coordinate(town.get().getLatitude(), town.get().getLongitude());
        Weather weather = restApiService.getWeather(coordinate);

        return weatherViewMapper.weatherToWeatherResponse(weather, town.get().getType());
    }
}
