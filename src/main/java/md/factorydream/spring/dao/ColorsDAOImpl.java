/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Colors;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class ColorsDAOImpl extends AbstractSpringDao implements ColorsDAO {

    @Override
    public void save(Colors colors) {
        super.saveOrUpdate(colors);
    }

    @Override
    public List findAll() {
        return super.findAll(Colors.class);
    }

    @Override
    public List findAllEnableColors() {
        return super.findAllDataEnableObject(Colors.class);
    }

    @Override
    public Colors findColorsById(short id) {
        return (Colors) super.findClassById(Colors.class, id);
    }

}
