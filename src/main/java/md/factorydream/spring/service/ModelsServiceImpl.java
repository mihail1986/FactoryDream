/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.Models;
import md.factorydream.entites.rest.ModelValueRest;
import md.factorydream.spring.dao.ModelsDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class ModelsServiceImpl implements ModelsService {

    private ModelsDAO modelsDAO;

    public void setModelsDAO(ModelsDAO modelsDAO) {
        this.modelsDAO = modelsDAO;
    }

    @Override
    @Transactional
    public void save(Models models) {
        modelsDAO.save(models);
    }

    @Override
    @Transactional
    public List findAll() {
        return modelsDAO.findAll();
    }

    @Override
    @Transactional
    public List findAllEnableModels() {
        return modelsDAO.findAllEnableModels();
    }

    @Override
    public List findAllEnableModelsRest() {
        List modelValuelRestList = new ArrayList();

        List modelList = findAllEnableModels();

        for (Object models : modelList) {
            Models model = (Models) models;

            ModelValueRest modeValuelRest = new ModelValueRest(model.getId(), model.getValue());
            modelValuelRestList.add(modeValuelRest);
        }
        return modelValuelRestList;
    }

    @Override
    @Transactional
    public Models findModelsById(short id) {
        return modelsDAO.findModelsById(id);

    }

}
