/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.Threads;
import md.factorydream.entites.rest.ThreadsValueRest;
import md.factorydream.spring.dao.ThreadsDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class ThreadsServiceImpl implements ThreadsService {

    private ThreadsDAO threadsDAO;

    public void setThreadsDAO(ThreadsDAO threadsDAO) {
        this.threadsDAO = threadsDAO;
    }

    @Override
    @Transactional
    public void save(Threads threads) {
        threadsDAO.save(threads);
    }

    @Override
    @Transactional
    public List findAll() {
        return threadsDAO.findAll();
    }

    @Override
    @Transactional
    public List findAllEnableThreads() {
        return threadsDAO.findAllEnableThreads();
    }

    @Override
    @Transactional
    public List findAllEnableThreadsRest() {
        List threadsValueRestList = new ArrayList();

        List threadsList = findAllEnableThreads();

        for (Object threads : threadsList) {
            Threads thread = (Threads) threads;

            ThreadsValueRest threadsValuelRest = new ThreadsValueRest(thread.getId(), thread.getValue());
            threadsValueRestList.add(threadsValuelRest);
        }

        return threadsValueRestList;

    }

}
