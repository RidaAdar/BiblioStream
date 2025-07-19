package com.ferrovia.repository;

import com.ferrovia.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Tu peux ajouter ici des méthodes personnalisées si besoin (ex: findByName)
}
