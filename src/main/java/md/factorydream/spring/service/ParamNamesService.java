/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.ParamNames;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.ParamNamesUpdateRest;

/**
 *
 * @author Zaițev.Victor
 */
public interface ParamNamesService {

    public void save(ParamNames paramNames);

    public List findAll();

    public boolean update(ParamNamesUpdateRest paramNamesUpdateRest, Users users);
    
    public List findDistinctParamNames();
}
