package com.example.demo.view.placeData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceUpdateRequest {
    private String townName;
    private String type;
    private String countryName;
    private Double latitude;
    private Double longitude;
}