package com.example.demo.view.weatherData;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeatherResponse {
    @Setter(AccessLevel.PRIVATE)
    private String town;
    private String type;

    private Double temperature;
    private int humidity;
    private Double wind;
    private String conditon;
}
