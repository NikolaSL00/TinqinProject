package com.example.demo.domain.models;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Weather {
    @Setter(AccessLevel.PRIVATE)
    private String location;
    private Double temperature;
    private int humidity;
    private Double wind;
    private String conditon;
}
