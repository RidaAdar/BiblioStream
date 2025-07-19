package com.ferrovia.controller;

import com.ferrovia.model.Train;
import com.ferrovia.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
    private final TrainService service;
    public TrainController(TrainService service) { this.service = service; }

    @GetMapping
    public List<Train> getAllTrains() {
        return service.getAllTrains();
    }

    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable Long id) {
        return service.getTrainById(id);
    }

    @PostMapping
    public Train createTrain(@RequestBody Train train) {
        return service.createTrain(train);
    }

    @PutMapping("/{id}")
    public Train updateTrain(@PathVariable Long id, @RequestBody Train train) {
        return service.updateTrain(id, train);
    }

    @DeleteMapping("/{id}")
    public void deleteTrain(@PathVariable Long id) {
        service.deleteTrain(id);
    }

    // Liste des trains d'une station
    @GetMapping("/station/{stationId}")
    public List<Train> getByStation(@PathVariable Long stationId) {
        return service.getByStation(stationId);
    }

    // Liste des trains par type
    @GetMapping("/type/{type}")
    public List<Train> getByType(@PathVariable String type) {
        return service.getByType(type);
    }
}
