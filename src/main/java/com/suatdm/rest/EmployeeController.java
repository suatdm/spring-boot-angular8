package com.suatdm.rest;

import com.suatdm.model.Employee;
import com.suatdm.resource.EmployeeListResource;
import com.suatdm.resource.EmployeeResource;
import com.suatdm.resource.asm.EmployeeListResourceAsm;
import com.suatdm.resource.asm.EmployeeResourceAsm;
import com.suatdm.resource.util.EmployeeList;
import com.suatdm.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @uthor Suat
 * @date 2019-08-19
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResource> saveEmployee(@Valid @RequestBody EmployeeResource sendRequest) {
        LOGGER.info("Employee is created. " + sendRequest);
        Employee employee = employeeService.save(sendRequest.toResource());
        EmployeeResource employeeResource = new EmployeeResourceAsm().toResource(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(employeeResource.getLink("self").getHref()));
        return new ResponseEntity<>(employeeResource, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResource> updateEmployee(@PathVariable String id, @RequestBody EmployeeResource employeeDetails) {

        LOGGER.info("Employee is update. " + id);
        Employee employee = employeeService.findOne(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        employee.setName(employeeDetails.getName());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setWorking(employeeDetails.getWorking());
        employee.setPhone(employeeDetails.getPhone());
        EmployeeResource employeeResource = new EmployeeResourceAsm().toResource(employee);
        employeeService.update(employeeResource.toResource());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(employeeResource, headers, HttpStatus.OK);
    }

    @GetMapping( value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResource> getEmployee(@PathVariable String id) {
        LOGGER.info("Get employee by id: " + id);

        Employee employee = employeeService.findOne(id).get();
        EmployeeResource employeeResource = new EmployeeResourceAsm().toResource(employee);
        return new ResponseEntity<>(employeeResource, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public Map< String, Boolean > deleteEmployee(@PathVariable String id) {
        LOGGER.info("Employee is deleted. " + id);

        Employee employee = employeeService.findOne(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        employeeService.deleteEmployee(employee);
        Map < String, Boolean > response = new HashMap< >();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<EmployeeListResource> listAllEmployee(){
        LOGGER.info("List all employee.");
        EmployeeList employeeList = employeeService.listAll();
        EmployeeListResource employeeListResource = new EmployeeListResourceAsm().toResource(employeeList);
        return new ResponseEntity<EmployeeListResource>(employeeListResource, HttpStatus.OK);
    }


}
