/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.OrderNote;

/**
 *
 * @author Zaițev.Victor
 */
public interface OrdersNoteService {

    public void save(OrderNote OrderNote);

    public List findAll();

    public List findAllEnableOrderNotes();

    public long countNotesPerOrder(long orderId);

    public List findOrderNoteByOrderId(long orderId);

    public List findOrderNoteRestByOrderId(long orderId);
}
