// LivreService.java
package com.ferrovia.service;

import com.ferrovia.model.Livre;
import com.ferrovia.repository.LivreRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivreService {
    private final LivreRepository repo;
    public LivreService(LivreRepository repo) { this.repo = repo; }
    public List<Livre> getAll() { return repo.findAll(); }
    public Livre save(Livre l) { return repo.save(l); }
    public void delete(Long id) { repo.deleteById(id); }
    public Livre getById(Long id) { return repo.findById(id).orElse(null); }
}
