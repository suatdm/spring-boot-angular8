package com.suatdm.service;

import com.mongodb.lang.Nullable;
import com.suatdm.model.Employee;
import com.suatdm.repository.EmployeeRepository;
import com.suatdm.resource.util.EmployeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @uthor Suat
 * @date 2019-08-19
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Employee save(@Nullable Employee employee) {
        employee.setCreatedDate(LocalDate.now());
        employee.setWorking(Boolean.TRUE);
        return repository.save(employee);
    }

    public Employee update(@Nullable Employee employee) {
        return repository.save(employee);
    }

    public EmployeeList listAll(){
        return new EmployeeList(repository.findAll());
    }

    public Optional<Employee> findOne(@Nullable String id) {
        return repository.findById(id);
    }

    public void deleteEmployee(@Nullable Employee employee) {
        repository.delete(employee);
    }
}
