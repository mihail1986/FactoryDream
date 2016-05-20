/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.OrderNote;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mihail.Cepraga
 */
@Repository
public class OrderNoteDAOImpl extends AbstractSpringDao implements OrderNoteDAO {

    @Override
    public void save(OrderNote OrderNote) {
        super.saveOrUpdate(OrderNote);
    }

    @Override
    public List findAll() {
        return super.findAll(OrderNote.class);
    }

    @Override
    public List findAllEnableOrderNotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long countNotesPerOrder(long orderId) {
        
        long OrderNotesCount = 0;
        
        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" FROM OrderNote "
                                            + " WHERE orders.id=:OrderID");

        query.setLong("OrderID", orderId);
        
        
        List list = query.list();
        
        if (list != null && list.size() > 0) {
            OrderNotesCount = (long) list.size();
        }
        
        return OrderNotesCount; 
    }
    
}
