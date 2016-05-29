/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.Diameters;
import md.factorydream.entites.rest.DiametersValueRest;
import md.factorydream.spring.dao.DiametersDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class DiametersServiceImpl implements DiametersService {

    private DiametersDAO diametersDAO;

    public void setDiametersDAO(DiametersDAO diametersDAO) {
        this.diametersDAO = diametersDAO;
    }

    @Override
    @Transactional
    public void save(Diameters diameters) {
        diametersDAO.save(diameters);
    }

    @Override
    @Transactional
    public List findAll() {
        return diametersDAO.findAll();
    }

    @Override
    @Transactional
    public List findAllEnableDiameters() {
        return diametersDAO.findAllEnableDiameters();
    }

    @Override
    public List findAllEnableDiametersRest() {
        List diametersValueRestList = new ArrayList();

        List diametersList = findAllEnableDiameters();

        for (Object diameters : diametersList) {
            Diameters diameter = (Diameters) diameters;

            DiametersValueRest diametersValuelRest = new DiametersValueRest(diameter.getId(), diameter.getValue());
            diametersValueRestList.add(diametersValuelRest);
        }

        return diametersValueRestList;

    }

}
