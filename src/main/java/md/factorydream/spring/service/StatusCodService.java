/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.StatusCod;

/**
 *
 * @author Zaițev.Victor
 */
public interface StatusCodService {

    public void save(StatusCod statusCod);

    public List findAll();

    public List findStatusCodByGroupId(short groupId);

    public StatusCod findStatusCodByCodName(String codName);

    public StatusCod findStatusCodById(short id);
}
