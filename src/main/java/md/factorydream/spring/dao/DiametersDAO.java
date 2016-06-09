/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Diameters;

/**
 *
 * @author Zaițev.Victor
 */
public interface DiametersDAO {

    public void save(Diameters diameters);

    public List findAll();

    public List findAllEnableDiameters();

    public Diameters findDiametersById(short id);
}
