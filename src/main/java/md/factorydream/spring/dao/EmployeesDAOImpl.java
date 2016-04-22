/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Employees;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class EmployeesDAOImpl extends AbstractSpringDao implements EmployeesDAO {

    @Override
    public void save(Employees employees) {
        super.saveOrUpdate(employees);

    }

    @Override
    public List findAll() {
        return super.findAll(Employees.class);
    }

}
