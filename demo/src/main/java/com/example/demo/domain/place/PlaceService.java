package com.example.demo.domain.place;

import com.example.demo.view.placeData.PlaceCreateRequest;
import com.example.demo.view.placeData.PlaceResponse;
import com.example.demo.view.placeData.PlaceUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlaceService {

    List<PlaceResponse> findAll();

    ResponseEntity<PlaceResponse> getPlace(String id);

    String createPlace(PlaceCreateRequest placeRequest);

    int deletePlace(String id);

    int updatePlace(String id, PlaceUpdateRequest placeUpdateRequest);
}
