package org.shynwolf.webapp.repository;

import lombok.extern.slf4j.Slf4j;
import org.shynwolf.webapp.config.CustomProperties;
import org.shynwolf.webapp.model.Employee;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
public class EmployeeProxy {

    private final CustomProperties props;

    public EmployeeProxy(CustomProperties props) {
        this.props = props;
    }

    public List<Employee> getEmployees() {
        String getEmployeeUrl = props.getApiUrl() + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                getEmployeeUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {}
        );

        log.debug("Get Employees call {}", response.getStatusCode().toString());

        return response.getBody();
    }

//    public Employee getEmployee() {
//        String getEmployeeUrl = props.getApiUrl() + "/employee";
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<Employee>> response = restTemplate.exchange(
//                getEmployeeUrl,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Employee>>() {}
//        );
//
//        log.debug("Get Employees call {}", response.getStatusCode().toString());
//
//        return response.getBody();
//    }

    public Employee createEmployee(Employee e) {
        String createEmployeeUrl = props.getApiUrl() + "/addEmployee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(e);
        ResponseEntity<Employee> response = restTemplate.exchange(
                createEmployeeUrl,
                HttpMethod.POST,
                request,
                Employee.class);

        log.debug("Create Employee call {}", response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteEmployee(int id) {
    }
}
