/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.Types;

/**
 *
 * @author Zaițev.Victor
 */
public interface TypesService {

    public void save(Types types);

    public List findAll();

    public List findAllEnableTypes();

    public List findAllEnableTypesRest();

    public Types findTypesById(short id);
}
