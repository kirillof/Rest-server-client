package com.kirillkirillov.spring.rest;

import com.kirillkirillov.spring.rest.configuration.MyConfig;
import com.kirillkirillov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee employee = communication.getEmployee(1);
//        System.out.println(employee);

//        Employee employee = new Employee("Sveta", "Skolova", "HR", 1800);
//        employee.setId(10);
//        communication.saveEmployee(employee);

        communication.deleteEmployee(10);
    }
}
