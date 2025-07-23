// EmpruntService.java
package com.ferrovia.service;

import com.ferrovia.model.Emprunt;
import com.ferrovia.repository.EmpruntRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpruntService {
    private final EmpruntRepository repo;
    public EmpruntService(EmpruntRepository repo) { this.repo = repo; }
    public List<Emprunt> getAll() { return repo.findAll(); }
    public Emprunt save(Emprunt e) { return repo.save(e); }
    public void delete(Long id) { repo.deleteById(id); }
    public Emprunt getById(Long id) { return repo.findById(id).orElse(null); }
}
