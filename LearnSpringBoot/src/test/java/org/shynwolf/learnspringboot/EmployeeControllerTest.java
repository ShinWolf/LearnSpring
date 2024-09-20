package org.shynwolf.learnspringboot;

import org.junit.jupiter.api.Test;
import org.shynwolf.learnspringboot.controller.EmployeeController;
import org.shynwolf.learnspringboot.model.Employee;
import org.shynwolf.learnspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void  testGetAllEmployees() throws Exception {
        when(employeeService.getAllEmployees())
                .thenReturn(Collections.singletonList(new Employee(1L, "Dupont", "Jean", "jean.dupont@example.com", "password")));

        mockMvc.perform(get("/employees")).andExpect(status().isOk()).andExpect(jsonPath("$[0].nom", is("Dupont")));
    }
}
