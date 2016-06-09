/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Models;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class ModelsDAOImpl extends AbstractSpringDao implements ModelsDAO {

    @Override
    public void save(Models models) {
        super.saveOrUpdate(models);
    }

    @Override
    public List findAll() {
        return super.findAll(Models.class);
    }

    @Override
    public List findAllEnableModels() {
        return super.findAllDataEnableObject(Models.class);
    }

    @Override
    public Models findModelsById(short id) {
        return (Models) super.findClassById(Models.class, id);
    }

}
