/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.GroupNotes;
import md.factorydream.spring.dao.GroupNotesDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class GroupNotesServiceImpl implements GroupNotesService {

    private GroupNotesDAO groupNotesDAO;

    public void setGroupNotesDAO(GroupNotesDAO groupNotesDAO) {
        this.groupNotesDAO = groupNotesDAO;
    }

    @Override
    @Transactional
    public void save(GroupNotes groupNotes) {
        groupNotesDAO.save(groupNotes);
    }

    @Override
    @Transactional
    public List findAll() {
        return groupNotesDAO.findAll();
    }

}
