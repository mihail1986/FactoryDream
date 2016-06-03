/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.MenuValueRest;
import md.factorydream.spring.dao.SpringDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class SpringServiceImpl implements SpringService {

    private SpringDAO springDAO;

    public void setSpringDAO(SpringDAO springDAO) {
        this.springDAO = springDAO;
    }

    @Override
    @Transactional
    public MenuValueRest selectMeniu() {

        List selectMeniuList = springDAO.selectMeniu();

        MenuValueRest menuValueRest = new MenuValueRest(selectMeniuList);

        return menuValueRest;
    }

}
