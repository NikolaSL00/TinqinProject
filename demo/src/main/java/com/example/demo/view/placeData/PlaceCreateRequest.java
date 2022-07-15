package com.example.demo.view.placeData;


import lombok.*;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceCreateRequest {
    private String townName;
    private String type;
    private String countryName;
    private Double latitude;
    private Double longitude;
}
