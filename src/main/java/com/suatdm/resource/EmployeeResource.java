package com.suatdm.resource;

import com.suatdm.model.Employee;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;

/**
 * @uthor Suat
 * @date 2019-08-19
 */
public class EmployeeResource extends ResourceSupport {

    private String rid;
    private LocalDate createdDate;
    private String name;
    private String department;
    private Number phone;
    private Boolean working;

    public Employee toResource(){
        Employee employee = new Employee();
        employee.setId(rid);
        employee.setCreatedDate(createdDate);
        employee.setName(name);
        employee.setDepartment(department);
        employee.setPhone(phone);
        employee.setWorking(working);
        return employee;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Number getPhone() {
        return phone;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }

    public Boolean getWorking() {
        return working;
    }

    public void setWorking(Boolean working) {
        this.working = working;
    }
}
