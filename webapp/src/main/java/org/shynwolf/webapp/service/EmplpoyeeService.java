package org.shynwolf.webapp.service;

import lombok.Data;
import org.shynwolf.webapp.model.Employee;
import org.shynwolf.webapp.repository.EmployeeProxy;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmplpoyeeService {

    private final EmployeeProxy employeeProxy;

    public EmplpoyeeService(EmployeeProxy employeeProxy) {
        this.employeeProxy = employeeProxy;
    }

    public Employee getEmployee(final int id) {
        return employeeProxy.getEmployee(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }

    public void deleteEmployee(final int id) {
        employeeProxy.deleteEmployee(id);;
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        employee.setNom(employee.getNom().toUpperCase());

        if(employee.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedEmployee = employeeProxy.createEmployee(employee);
        } else {
            savedEmployee = employeeProxy.updateEmployee(employee);
        }

        return savedEmployee;
    }
}
