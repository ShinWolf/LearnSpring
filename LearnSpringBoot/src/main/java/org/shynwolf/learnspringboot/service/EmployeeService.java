package org.shynwolf.learnspringboot.service;

import org.shynwolf.learnspringboot.model.Employee;
import org.shynwolf.learnspringboot.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeRepository employeRepository;

    public EmployeeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public Employee getEmployeById(Long id) {
        return employeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> getAllEmployees() {
        return employeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee updateEmployee) {
        Employee existingEmployee = employeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setNom(updateEmployee.getNom());
        existingEmployee.setPrenom(updateEmployee.getPrenom());
        existingEmployee.setEmail(updateEmployee.getEmail());
        existingEmployee.setPassword(updateEmployee.getPassword());

        return employeRepository.save(existingEmployee);
    }
}
