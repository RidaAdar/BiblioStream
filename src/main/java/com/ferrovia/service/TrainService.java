package com.ferrovia.service;

import com.ferrovia.model.Train;
import com.ferrovia.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    private final TrainRepository repo;
    public TrainService(TrainRepository repo) { this.repo = repo; }

    public List<Train> getAllTrains() {
        return repo.findAll();
    }

    public Train createTrain(Train t) {
        return repo.save(t);
    }

    public Train getTrainById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Train updateTrain(Long id, Train t) {
        t.setId(id);
        return repo.save(t);
    }

    public void deleteTrain(Long id) {
        repo.deleteById(id);
    }

    public List<Train> getByType(String type) {
        return repo.findByType(type);
    }

    public List<Train> getByStation(Long stationId) {
        return repo.findByStationId(stationId);
    }
}
