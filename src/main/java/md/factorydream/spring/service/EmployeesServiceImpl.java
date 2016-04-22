/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.Employees;
import md.factorydream.spring.dao.EmployeesDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class EmployeesServiceImpl implements EmployeesService {

    private EmployeesDAO employeesDAO;

    public void setEmployeesDAO(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
    }

    @Override
    @Transactional
    public void save(Employees employees) {
        employeesDAO.save(employees);
    }

    @Override
    @Transactional
    public List findAll() {
        return employeesDAO.findAll();
    }

}
