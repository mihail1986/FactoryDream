/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.Colors;
import md.factorydream.entites.rest.ColorsValueRest;
import md.factorydream.spring.dao.ColorsDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class ColorsServiceImpl implements ColorsService {

    private ColorsDAO colorsDAO;

    public void setColorsDAO(ColorsDAO colorsDAO) {
        this.colorsDAO = colorsDAO;
    }

    @Override
    @Transactional
    public void save(Colors colors) {
        colorsDAO.save(colors);
    }

    @Override
    @Transactional
    public List findAll() {
        return colorsDAO.findAll();
    }

    @Override
    @Transactional
    public List findAllEnableColors() {
        return colorsDAO.findAllEnableColors();
    }

    @Override
    public List findAllEnableColorsRest() {
        List colorsValueRestList = new ArrayList();

        List colorsList = findAllEnableColors();

        for (Object colors : colorsList) {
            Colors color = (Colors) colors;

            ColorsValueRest colorsValuelRest = new ColorsValueRest(color.getId(), color.getValue());
            colorsValueRestList.add(colorsValuelRest);
        }

        return colorsValueRestList;

    }

    @Override
    @Transactional
    public Colors findColorsById(short id) {
        return colorsDAO.findColorsById(id);
    }
}
