package com.suatdm.resource.asm;

import com.suatdm.resource.EmployeeListResource;
import com.suatdm.resource.util.EmployeeList;
import com.suatdm.rest.EmployeeController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * @uthor Suat
 * @date 2019-08-19
 */
public class EmployeeListResourceAsm extends ResourceAssemblerSupport<EmployeeList, EmployeeListResource> {

    public EmployeeListResourceAsm() {
        super(EmployeeController.class, EmployeeListResource.class);
    }

    @Override
    public EmployeeListResource toResource(EmployeeList employeeList) {
        EmployeeListResource listResource = new EmployeeListResource();
        listResource.setEmployeeResourceList(new EmployeeResourceAsm().toResources(employeeList.getEmployeeList()));
        return listResource;
    }
}
