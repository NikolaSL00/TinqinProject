package com.example.demo.view.mappers;

import com.example.demo.data.models.entities.Town;
import com.example.demo.view.placeData.PlaceResponse;
import org.springframework.stereotype.Service;

@Service
public class TownViewMapper {

    public PlaceResponse townToPlaceResponse(Town town){
        return PlaceResponse.builder()
                .name(town.getName())
                .country(town.getCountry().getName())
                .type(town.getType().getLabel())
                .latitude(town.getLatitude())
                .longitude(town.getLongitude())
                .build();
    }
}
