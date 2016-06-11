/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Types;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class TypesDAOImpl extends AbstractSpringDao implements TypesDAO {

    @Override
    public void save(Types types) {
        super.saveOrUpdate(types);
    }

    @Override
    public List findAll() {
        return super.findAll(Types.class);
    }

    @Override
    public List findAllEnableTypes() {
        return super.findAllDataEnableObject(Types.class);
    }

    @Override
    public Types findTypesById(short id) {
        return (Types) super.findClassById(Types.class, id);
    }

}
