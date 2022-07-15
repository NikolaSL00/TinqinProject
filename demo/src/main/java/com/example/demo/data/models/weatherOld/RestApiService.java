package com.example.demo.data.models.weatherOld;

import com.example.demo.domain.models.Coordinate;
import com.example.demo.domain.models.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestApiService {

    private final String basicUrl =
            "http://api.weatherapi.com/v1/current.json?key=68144b847bc64e6cadf90133220807&q=";

    private final RestTemplate restTemplate;


    public RestApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Weather getWeather(Coordinate coords) {

        StringBuilder stringBuilder = new StringBuilder(basicUrl + "" + coords.getX() + "," + coords.getY());
        String url = stringBuilder.toString();

        Root root = restTemplate.getForObject(url, Root.class);

        assert root != null;

        return Weather.builder()
                .location(root.getLocation().getRegion())
                .temperature(root.getCurrent().getFeelslike_c())
                .humidity(root.getCurrent().getHumidity())
                .wind(root.getCurrent().getWind_kph())
                .conditon(root.getCurrent().getCondition().getText())
                .build();
    }
}
