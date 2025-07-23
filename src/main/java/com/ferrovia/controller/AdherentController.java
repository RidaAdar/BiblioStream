// AdherentController.java
package com.ferrovia.controller;

import com.ferrovia.model.Adherent;
import com.ferrovia.repository.AdherentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/adherents")
public class AdherentController {
    private final AdherentRepository repo;
    public AdherentController(AdherentRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Adherent> getAll() { return repo.findAll(); }
    @PostMapping
    public Adherent create(@RequestBody Adherent a) { return repo.save(a); }
    @GetMapping("/{id}")
    public Adherent get(@PathVariable Long id) { return repo.findById(id).orElse(null); }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
