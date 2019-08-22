package com.suatdm.resource.util;

import com.suatdm.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @uthor Suat
 * @date 2019-08-19
 */
public class EmployeeList {

    public List<Employee> employeeList = new ArrayList<>();

    public EmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
