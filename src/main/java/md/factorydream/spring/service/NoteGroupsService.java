/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.NoteGroups;

/**
 *
 * @author Zaițev.Victor
 */
public interface NoteGroupsService {

    public void save(NoteGroups noteGroups);

    public List findAll();

    public NoteGroups findNoteGroupsById(long id);

    public List findAllNoteGroupsRest();

}
