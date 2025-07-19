package com.ferrovia.repository;

import com.ferrovia.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {
    List<Intervention> findByTrainId(Long trainId);
}
