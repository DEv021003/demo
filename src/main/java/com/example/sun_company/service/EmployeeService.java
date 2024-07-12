package com.example.sun_company.service;

import com.example.sun_company.model.Employee;
import com.example.sun_company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null); // Trả về null nếu không tìm thấy
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalExistingEmployee = employeeRepository.findById(id);
        if (optionalExistingEmployee.isPresent()) {
            Employee existingEmployee = optionalExistingEmployee.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setWage(updatedEmployee.getWage());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }
}
