/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.NoteGroups;

/**
 *
 * @author Zaițev.Victor
 */
public class NoteGroupsDAOImpl extends AbstractSpringDao implements NoteGroupsDAO {

    @Override
    public void save(NoteGroups noteGroups) {
        super.saveOrUpdate(noteGroups);
    }

    @Override
    public List findAll() {
        return super.findAll(NoteGroups.class);
    }

    @Override
    public NoteGroups findNoteGroupsById(long id) {
        return (NoteGroups) super.find(NoteGroups.class, id);
    }

}
