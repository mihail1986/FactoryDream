/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.GroupNotes;

/**
 *
 * @author Zaițev.Victor
 */
public interface GroupNotesService {

    public void save(GroupNotes groupNotes);

    public List findAll();
}
