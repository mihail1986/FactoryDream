/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.GroupNotes;

/**
 *
 * @author Zaițev.Victor
 */
public class GroupNotesDAOImpl extends AbstractSpringDao implements GroupNotesDAO {

    @Override
    public void save(GroupNotes groupNotes) {
        super.saveOrUpdate(groupNotes);
    }

    @Override
    public List findAll() {
        return super.findAll(GroupNotes.class);
    }

}
