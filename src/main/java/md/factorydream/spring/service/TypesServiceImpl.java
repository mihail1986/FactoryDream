/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.Types;
import md.factorydream.entites.rest.TypesValueRest;
import md.factorydream.spring.dao.TypesDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class TypesServiceImpl implements TypesService {

    private TypesDAO typesDAO;

    public void setTypesDAO(TypesDAO typesDAO) {
        this.typesDAO = typesDAO;
    }

    @Override
    @Transactional
    public void save(Types types) {
        typesDAO.save(types);
    }

    @Override
    @Transactional
    public List findAll() {
        return typesDAO.findAll();
    }

    @Override
    @Transactional
    public List findAllEnableTypes() {
        return typesDAO.findAllEnableTypes();
    }

    @Override
    public List findAllEnableTypesRest() {

        List typesValueRestList = new ArrayList();

        List typesList = findAllEnableTypes();

        for (Object types : typesList) {
            Types type = (Types) types;

            TypesValueRest typesValuelRest = new TypesValueRest(type.getId(), type.getValue());
            typesValueRestList.add(typesValuelRest);
        }

        return typesValueRestList;

    }

}
