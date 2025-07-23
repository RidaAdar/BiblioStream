// EmpruntController.java
package com.ferrovia.controller;

import com.ferrovia.model.Emprunt;
import com.ferrovia.repository.EmpruntRepository;
import com.ferrovia.kafka.KafkaProducerService;
import com.ferrovia.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {
    @Autowired
    private EmpruntRepository repo;
    @Autowired
    private KafkaProducerService kafkaProducerService;
    @Autowired
    private MinioService minioService;

    @GetMapping
    public List<Emprunt> getAll() { return repo.findAll(); }

    @PostMapping
    public Emprunt create(@RequestBody Emprunt e) {
        Emprunt saved = repo.save(e);
        kafkaProducerService.sendEmprunt(saved);
        minioService.uploadString("emprunt-" + saved.getId() + ".txt", saved.toString());
        return saved;
    }
}
