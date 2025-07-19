package com.ferrovia.service;

import com.ferrovia.model.Intervention;
import com.ferrovia.repository.InterventionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionService {
    private final InterventionRepository repo;
    public InterventionService(InterventionRepository repo) { this.repo = repo; }

    public List<Intervention> getAllInterventions() {
        return repo.findAll();
    }

    public Intervention createIntervention(Intervention i) {
        return repo.save(i);
    }

    public Intervention getInterventionById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Intervention updateIntervention(Long id, Intervention i) {
        i.setId(id);
        return repo.save(i);
    }

    public void deleteIntervention(Long id) {
        repo.deleteById(id);
    }

    public List<Intervention> getByTrain(Long trainId) {
        return repo.findByTrainId(trainId);
    }
}
