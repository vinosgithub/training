package com.training.service;

import com.training.entities.EmployeeEntity;
import com.training.to.EmployeeTO;

public interface EmployeeService {

    EmployeeEntity save(EmployeeTO employeeTO);
    EmployeeEntity findById(Long employeeId);


}
