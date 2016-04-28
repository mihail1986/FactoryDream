/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Threads;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class ThreadsDAOImpl extends AbstractSpringDao implements ThreadsDAO {

    @Override
    public void save(Threads threads) {
        super.saveOrUpdate(threads);
    }

    @Override
    public List findAll() {
        return super.findAll(Threads.class);
    }

    @Override
    public List findAllEnableThreads() {
        return super.findAllDataEnableObject(Threads.class);
    }

}
