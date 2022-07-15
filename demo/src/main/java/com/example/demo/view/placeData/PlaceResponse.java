package com.example.demo.view.placeData;


import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlaceResponse {
    private String name;
    private String type;
    private Double latitude;
    private Double longitude;
    private String country;
}
