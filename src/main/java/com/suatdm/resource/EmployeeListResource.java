package com.suatdm.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @uthor Suat
 * @date 2019-08-19
 */
public class EmployeeListResource extends ResourceSupport {

    public List<EmployeeResource> employeeResourceList = new ArrayList<>();

    public List<EmployeeResource> getEmployeeResourceList() {
        return employeeResourceList;
    }

    public void setEmployeeResourceList(List<EmployeeResource> employeeResourceList) {
        this.employeeResourceList = employeeResourceList;
    }
}
