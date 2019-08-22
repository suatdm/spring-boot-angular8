package com.suatdm.resource.asm;

import com.suatdm.model.Employee;
import com.suatdm.resource.EmployeeResource;
import com.suatdm.rest.EmployeeController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @uthor Suat
 * @date 2019-08-19
 */
public class EmployeeResourceAsm  extends ResourceAssemblerSupport<Employee, EmployeeResource> {

    public EmployeeResourceAsm() {
        super(EmployeeController.class, EmployeeResource.class);
    }

    @Override
    public EmployeeResource toResource(Employee employee) {
        EmployeeResource resource = new EmployeeResource();
        resource.setRid(employee.getId());
        resource.setCreatedDate(employee.getCreatedDate());
        resource.setDepartment(employee.getDepartment());
        resource.setName(employee.getName());
        resource.setPhone(employee.getPhone());
        resource.setWorking(employee.getWorking());
        resource.add(linkTo(methodOn(EmployeeController.class).getEmployee(employee.getId())).withSelfRel());

        return resource;
    }
}
