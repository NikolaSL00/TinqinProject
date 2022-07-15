package com.example.demo.data.models.weatherOld;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location{
    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tz_id;
    private int localtime_epoch;
    private String localtime;
}
