package com.dev.buildtalent.service;

import com.dev.buildtalent.entity.Employee;
import com.dev.buildtalent.repository.EmployeeRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

     public  EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Cacheable(value = "employee")
    public List<Employee> findAll(){
        return this.employeeRepository.findAll();
    }

    @CachePut(value = "employee", key = "#employee.id")
    public Employee saveEmployee(Employee employee){
         return  this.employeeRepository.save(employee);
    }
    @Cacheable(value = "employee", key = "#id")
    public Optional<Employee> findByEmpId(Integer id){
         return  this.employeeRepository.findById(id);
    }
    @CacheEvict(value = "employee", key = "#id")
    public void deleteEmp(Integer id){
         this.employeeRepository.deleteById(id);
    }
}
