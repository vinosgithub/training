package com.training.rest;

import com.training.entities.EmployeeEntity;
import com.training.service.EmployeeService;
import com.training.to.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeRestService {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EmployeeEntity> save(
            @RequestBody EmployeeTO employeeTO){

        EmployeeEntity employeeEntity = employeeService.save(employeeTO);

        return new ResponseEntity<>(employeeEntity, HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EmployeeEntity> findById(
            @RequestParam(name = "empoyeeId") Long empoyeeId){

        EmployeeEntity employeeEntity = employeeService.findById(empoyeeId);

        return new ResponseEntity<>(employeeEntity, HttpStatus.ACCEPTED);
    }

}
