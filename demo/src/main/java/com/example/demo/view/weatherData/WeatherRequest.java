package com.example.demo.view.weatherData;

import lombok.*;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherRequest {
    private String country;
    private String label;
}