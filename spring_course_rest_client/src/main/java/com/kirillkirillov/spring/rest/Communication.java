package com.kirillkirillov.spring.rest;

import com.kirillkirillov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    private final String url = "http://localhost:8080/spring_course_rest/api/employees";

    @Autowired
    private RestTemplate restTemplate;

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
        });
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(url + "/" + id, Employee.class);
        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, employee, String.class);
            System.out.println("New Employee was addead to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(url, employee);
            System.out.println("Employee with ID " + id + " was updated");
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(url + "/" + id);
        System.out.println("Employee with ID " + id + " was deleted from DB");
    }

}
