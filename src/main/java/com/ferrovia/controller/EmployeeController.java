package com.ferrovia.controller;

import com.ferrovia.model.Employee;
import com.ferrovia.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) { this.service = service; }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }

    // Liste des employés d'un département
    @GetMapping("/department/{departmentId}")
    public List<Employee> getByDepartment(@PathVariable Long departmentId) {
        return service.getByDepartment(departmentId);
    }

    // Liste des employés par rôle
    @GetMapping("/role/{role}")
    public List<Employee> getByRole(@PathVariable String role) {
        return service.getByRole(role);
    }
}
