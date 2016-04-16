/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Employees;

/**
 *
 * @author Victor
 */
public interface EmployeesDAO {

    public void save(Employees employees);

    public List findAll();
}
