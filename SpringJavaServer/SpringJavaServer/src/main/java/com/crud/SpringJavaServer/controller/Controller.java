package com.crud.SpringJavaServer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.crud.SpringJavaServer.exception.ResourceNotFoundException;
import com.crud.SpringJavaServer.model.Place;
import com.crud.SpringJavaServer.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")

public class Controller {
    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/places")
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @GetMapping("/places/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable(value = "id") Long placeId)
            throws ResourceNotFoundException {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new ResourceNotFoundException("Place not found for this id :: " + placeId));
        return ResponseEntity.ok().body(place);
    }
    @PostMapping("/places")
    public Place createPlace(@Valid @RequestBody Place place) {
        return placeRepository.save(place);
    }

    @PutMapping("/places/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable(value = "id") Long placeId,
                                                   @Valid @RequestBody Place placeDetails) throws ResourceNotFoundException {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new ResourceNotFoundException("Place not found for this id :: " + placeId));

        place.setCoordinates(placeDetails.getCoordinates());
        place.setDescription(placeDetails.getDescription());
        place.setPlaceName(placeDetails.getPlaceName());
        final Place updatedPlace = placeRepository.save(place);
        return ResponseEntity.ok(updatedPlace);
    }

    @DeleteMapping("/places/{id}")
    public Map<String, Boolean> deletePlace(@PathVariable(value = "id") Long placeId)
            throws ResourceNotFoundException {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new ResourceNotFoundException("Place not found for this id :: " + placeId));

        placeRepository.delete(place);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
