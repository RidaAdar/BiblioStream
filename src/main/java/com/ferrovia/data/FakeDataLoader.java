package com.ferrovia.data;

import com.ferrovia.model.*;
import com.ferrovia.repository.*;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZoneId;
import java.util.*;

@Component
public class FakeDataLoader implements CommandLineRunner {

    @Autowired DepartmentRepository departmentRepo;
    @Autowired EmployeeRepository employeeRepo;
    @Autowired TrainRepository trainRepo;
    @Autowired StationRepository stationRepo;
    @Autowired InterventionRepository interventionRepo;

    @Override
    public void run(String... args) {
        Faker faker = new Faker(new Locale("fr"));

        // Departments
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Department dep = new Department();
            dep.setName(faker.company().industry());
            departments.add(departmentRepo.save(dep));
        }

        // Employees
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Employee emp = new Employee();
            emp.setName(faker.name().fullName());
            emp.setRole(faker.job().position());
            emp.setDepartment(departments.get(faker.number().numberBetween(0, departments.size())));
            employees.add(employeeRepo.save(emp));
        }

        // Stations
        List<Station> stations = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Station s = new Station();
            s.setName(faker.address().cityName() + " Station");
            s.setCity(faker.address().city());
            stations.add(stationRepo.save(s));
        }

        // Trains
        List<Train> trains = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Train t = new Train();
            t.setCode("T-" + faker.number().digits(4));
            t.setType(faker.ancient().god()); // Juste pour l'exemple
            t.setStation(stations.get(faker.number().numberBetween(0, stations.size())));
            trains.add(trainRepo.save(t));
        }

        // Interventions
        for (int i = 0; i < 20; i++) {
            Intervention iv = new Intervention();
            iv.setDescription(faker.lorem().sentence());
            iv.setDate(faker.date().past(200, java.util.concurrent.TimeUnit.DAYS)
                    .toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            iv.setStation(stations.get(faker.number().numberBetween(0, stations.size())));
            iv.setTrain(trains.get(faker.number().numberBetween(0, trains.size())));
            // On associe 1 ou 2 employés au hasard
            int nbEmp = faker.number().numberBetween(1, 3);
            Set<Employee> selected = new HashSet<>();
            for (int j = 0; j < nbEmp; j++) {
                selected.add(employees.get(faker.number().numberBetween(0, employees.size())));
            }
            iv.setEmployees(new ArrayList<>(selected));
            interventionRepo.save(iv);
        }

        System.out.println("Fake data generated!");
    }
}
