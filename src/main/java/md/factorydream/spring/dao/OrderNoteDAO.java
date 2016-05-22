/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.OrderNote;

/**
 *
 * @author Mihail.Cepraga
 */
public interface OrderNoteDAO {

    public void save(OrderNote OrderNote);

    public List findAll();

    public List findAllEnableOrderNotes();

    public long countNotesPerOrder(long orderId);

    public List findOrderNoteByOrderId(long orderId);
}
