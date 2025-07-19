package com.ferrovia.repository;

import com.ferrovia.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {
    List<Station> findByCity(String city);
}
