package com.training.service;

import com.training.dao.EmployeeDao;
import com.training.entities.EmployeeEntity;
import com.training.to.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public EmployeeEntity save(EmployeeTO employeeTO) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeTO.getId());
        employeeEntity.setEmployename(employeeTO.getEmployeeName());

        return employeeDao.save(employeeEntity);
    }

    public EmployeeEntity findById(Long employeeId) {

        return employeeDao.findById(employeeId).get();
    }
}
