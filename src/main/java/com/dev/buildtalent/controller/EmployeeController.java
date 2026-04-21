package com.dev.buildtalent.controller;

import com.dev.buildtalent.entity.Employee;
import com.dev.buildtalent.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public Employee saveEmp(@RequestBody Employee employee){
        return this.employeeService.saveEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> findAll(){
    return this.employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable("id") Integer id){
        return this.employeeService.findByEmpId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmp(@PathVariable("id") Integer id){
        this.employeeService.deleteEmp(id);
    }
}
