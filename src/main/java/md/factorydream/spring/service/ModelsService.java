/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.Models;

/**
 *
 * @author Zaițev.Victor
 */
public interface ModelsService {

    public void save(Models models);

    public List findAll();

    public List findAllEnableModels();

    public List findAllEnableModelsRest();

    public Models findModelsById(short id);
}
