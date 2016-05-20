/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.StatusCod;
import md.factorydream.entites.rest.StatusCodeRest;
import md.factorydream.spring.dao.StatusCodDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class StatusCodServiceImpl implements StatusCodService {

    public StatusCodDAO statusCodDAO;

    public void setStatusCodDAO(StatusCodDAO statusCodDAO) {
        this.statusCodDAO = statusCodDAO;
    }

    @Override
    @Transactional
    public void save(StatusCod statusCod) {
        statusCodDAO.save(statusCod);
    }

    @Override
    @Transactional
    public List findAll() {
        return statusCodDAO.findAll();
    }

    @Override
    @Transactional
    public List findStatusCodByGroupId(short groupId) {
        List statusCodesRestList = new ArrayList();

        List stutusCodesList = statusCodDAO.findStatusCodByGroupId(groupId);

        for (Object statusCodes : stutusCodesList) {

            StatusCod statusCode = (StatusCod) statusCodes;

            StatusCodeRest statusCodeRest = new StatusCodeRest(statusCode.getId(), statusCode.getStatuses().getName());

            statusCodesRestList.add(statusCodeRest);
        }
        return statusCodesRestList;

    }

}
