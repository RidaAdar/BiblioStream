package com.ferrovia.service;

import com.ferrovia.model.Department;
import com.ferrovia.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository repo;
    public DepartmentService(DepartmentRepository repo) { this.repo = repo; }

    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    public Department createDepartment(Department department) {
        return repo.save(department);
    }

    public Department getDepartmentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Department updateDepartment(Long id, Department department) {
        department.setId(id);
        return repo.save(department);
    }

    public void deleteDepartment(Long id) {
        repo.deleteById(id);
    }
}
