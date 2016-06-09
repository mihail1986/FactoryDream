/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Diameters;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class DiametersDAOImpl extends AbstractSpringDao implements DiametersDAO {

    @Override
    public void save(Diameters diameters) {
        super.saveOrUpdate(diameters);
    }

    @Override
    public List findAll() {
        return super.findAll(Diameters.class);
    }

    @Override
    public List findAllEnableDiameters() {
        return super.findAllDataEnableObject(Diameters.class);
    }

    @Override
    public Diameters findDiametersById(short id) {
        return (Diameters) super.findClassById(Diameters.class, id);
    }

}
