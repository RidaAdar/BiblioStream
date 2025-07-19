package com.ferrovia.controller;

import com.ferrovia.model.Station;
import com.ferrovia.service.StationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class StationController {
    private final StationService service;
    public StationController(StationService service) { this.service = service; }

    @GetMapping
    public List<Station> getAllStations() {
        return service.getAllStations();
    }

    @GetMapping("/{id}")
    public Station getStationById(@PathVariable Long id) {
        return service.getStationById(id);
    }

    @PostMapping
    public Station createStation(@RequestBody Station station) {
        return service.createStation(station);
    }

    @PutMapping("/{id}")
    public Station updateStation(@PathVariable Long id, @RequestBody Station station) {
        return service.updateStation(id, station);
    }

    @DeleteMapping("/{id}")
    public void deleteStation(@PathVariable Long id) {
        service.deleteStation(id);
    }

    // Liste des stations d'une ville
    @GetMapping("/city/{city}")
    public List<Station> getByCity(@PathVariable String city) {
        return service.getByCity(city);
    }
}
