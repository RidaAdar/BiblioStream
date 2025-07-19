package com.ferrovia.service;

import com.ferrovia.model.Station;
import com.ferrovia.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    private final StationRepository repo;
    public StationService(StationRepository repo) { this.repo = repo; }

    public List<Station> getAllStations() {
        return repo.findAll();
    }

    public Station createStation(Station s) {
        return repo.save(s);
    }

    public Station getStationById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Station updateStation(Long id, Station s) {
        s.setId(id);
        return repo.save(s);
    }

    public void deleteStation(Long id) {
        repo.deleteById(id);
    }

    public List<Station> getByCity(String city) {
        return repo.findByCity(city);
    }
}
