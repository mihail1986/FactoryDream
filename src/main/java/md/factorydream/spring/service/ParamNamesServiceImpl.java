/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.OrderParameters;
import md.factorydream.entites.ParamNames;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.ParamNamesUpdateRest;
import md.factorydream.entites.rest.ParamNamesValueRest;
import md.factorydream.spring.dao.ParamNamesDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class ParamNamesServiceImpl implements ParamNamesService {

    private ParamNamesDAO paramNamesDAO;

    public void setParamNamesDAO(ParamNamesDAO paramNamesDAO) {
        this.paramNamesDAO = paramNamesDAO;
    }

    @Override
    @Transactional
    public void save(ParamNames paramNames) {
        this.paramNamesDAO.save(paramNames);
    }

    @Override
    @Transactional
    public List findAll() {
        return this.paramNamesDAO.findAll();

    }

    @Override
    @Transactional
    public boolean update(ParamNamesUpdateRest paramNamesUpdateRest, Users users) {
        return this.paramNamesDAO.update(paramNamesUpdateRest, users);

    }

    @Override
    @Transactional
    public List findDistinctParamNames() {

        List paramNamesValueRestList = new ArrayList();
        List paramNameList = paramNamesDAO.findDistinctParamNames();

        for (Object paramNames : paramNameList) {

            ParamNames paramName = (ParamNames) paramNames;
            ParamNamesValueRest paramNamesValueRest = new ParamNamesValueRest(paramName.getId(), paramName.getName());
            paramNamesValueRestList.add(paramNamesValueRest);
        }

        return paramNamesValueRestList;

    }

}
