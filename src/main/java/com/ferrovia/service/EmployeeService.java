package com.ferrovia.service;

import com.ferrovia.model.Employee;
import com.ferrovia.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo) { this.repo = repo; }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee createEmployee(Employee e) {
        return repo.save(e);
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee e) {
        e.setId(id);
        return repo.save(e);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    public List<Employee> getByDepartment(Long departmentId) {
        return repo.findByDepartmentId(departmentId);
    }

    public List<Employee> getByRole(String role) {
        return repo.findByRole(role);
    }
}
