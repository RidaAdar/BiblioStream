// LivreController.java
package com.ferrovia.controller;

import com.ferrovia.model.Livre;
import com.ferrovia.repository.LivreRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {
    private final LivreRepository repo;
    public LivreController(LivreRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Livre> getAll() { return repo.findAll(); }
    @PostMapping
    public Livre create(@RequestBody Livre l) { return repo.save(l); }
    @GetMapping("/{id}")
    public Livre get(@PathVariable Long id) { return repo.findById(id).orElse(null); }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
