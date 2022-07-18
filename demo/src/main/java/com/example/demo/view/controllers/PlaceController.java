package com.example.demo.view.controllers;

import com.example.demo.domain.place.PlaceService;
import com.example.demo.view.placeData.PlaceCreateRequest;
import com.example.demo.view.placeData.PlaceResponse;
import com.example.demo.view.placeData.PlaceUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/places")
    List<PlaceResponse> findAll(){
        return placeService.findAll();
    }

    @GetMapping(value = "/places", params = "id")
    ResponseEntity<PlaceResponse> getPlace(@RequestParam final String id) {
        return placeService.getPlace(id);
        // it returns the place
    }

    @PostMapping("/places/create")
    String createPlace(@RequestBody PlaceCreateRequest placeCreateRequest) {
        return placeService.createPlace(placeCreateRequest);
        // it returns the id of the new instance
    }

    @RequestMapping(value = "/places", method = RequestMethod.DELETE)
    int deletePlace(@RequestParam final String id) {
        return placeService.deletePlace(id);
        // returns 1 if place with that id was current
        // returns 0 if place with that id was not current before deletion
    }


    @PutMapping("/places/{id}")
    int editPlace(@PathVariable(value = "id") final String id,
                   @RequestBody PlaceUpdateRequest placeUpdateRequest) {
        return placeService.updatePlace(id, placeUpdateRequest);
        // returns 1 if place with that id was current before update
        // returns 0 if place with that id was not current before update, it does not create an instance
    }


}
