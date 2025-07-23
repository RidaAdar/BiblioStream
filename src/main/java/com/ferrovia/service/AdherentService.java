// AdherentService.java
package com.ferrovia.service;

import com.ferrovia.model.Adherent;
import com.ferrovia.repository.AdherentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdherentService {
    private final AdherentRepository repo;
    public AdherentService(AdherentRepository repo) { this.repo = repo; }
    public List<Adherent> getAll() { return repo.findAll(); }
    public Adherent save(Adherent a) { return repo.save(a); }
    public void delete(Long id) { repo.deleteById(id); }
    public Adherent getById(Long id) { return repo.findById(id).orElse(null); }
}
