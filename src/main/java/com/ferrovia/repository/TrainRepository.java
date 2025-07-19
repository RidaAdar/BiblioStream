package com.ferrovia.repository;

import com.ferrovia.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findByType(String type);
    List<Train> findByStationId(Long stationId);
}
