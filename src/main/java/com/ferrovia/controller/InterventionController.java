package com.ferrovia.controller;

import com.ferrovia.model.Intervention;
import com.ferrovia.service.InterventionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {
    private final InterventionService service;
    public InterventionController(InterventionService service) { this.service = service; }

    @GetMapping
    public List<Intervention> getAllInterventions() {
        return service.getAllInterventions();
    }

    @GetMapping("/{id}")
    public Intervention getInterventionById(@PathVariable Long id) {
        return service.getInterventionById(id);
    }

    @PostMapping
    public Intervention createIntervention(@RequestBody Intervention intervention) {
        return service.createIntervention(intervention);
    }

    @PutMapping("/{id}")
    public Intervention updateIntervention(@PathVariable Long id, @RequestBody Intervention intervention) {
        return service.updateIntervention(id, intervention);
    }

    @DeleteMapping("/{id}")
    public void deleteIntervention(@PathVariable Long id) {
        service.deleteIntervention(id);
    }

    // Liste des interventions sur un train
    @GetMapping("/train/{trainId}")
    public List<Intervention> getByTrain(@PathVariable Long trainId) {
        return service.getByTrain(trainId);
    }
}
