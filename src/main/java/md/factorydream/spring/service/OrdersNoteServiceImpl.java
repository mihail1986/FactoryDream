/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import md.factorydream.entites.OrderNote;
import md.factorydream.entites.UserDepartment;
import md.factorydream.entites.rest.OrderNoteRest;
import md.factorydream.spring.dao.OrderNoteDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class OrdersNoteServiceImpl implements OrdersNoteService {

    OrderNoteDAO orderNoteDAO;

    public void setOrderNoteDAO(OrderNoteDAO orderNoteDAO) {
        this.orderNoteDAO = orderNoteDAO;
    }

    @Override
    @Transactional
    public void save(OrderNote OrderNote) {
        orderNoteDAO.save(OrderNote);
    }

    @Override
    @Transactional
    public List findAll() {
        return orderNoteDAO.findAll();
    }

    @Override
    @Transactional
    public List findAllEnableOrderNotes() {
        return orderNoteDAO.findAllEnableOrderNotes();
    }

    @Override
    @Transactional
    public long countNotesPerOrder(long orderId) {
        return orderNoteDAO.countNotesPerOrder(orderId);
    }

    @Override
    @Transactional
    public List findOrderNoteByOrderId(long orderId) {
        return orderNoteDAO.findOrderNoteByOrderId(orderId);
    }

    @Override
    @Transactional
    public List findOrderNoteRestByOrderId(long orderId) {
        List orderNotesRestList = new ArrayList();

        List ordersNoteList = findOrderNoteByOrderId(orderId);

        for (Object orderNotes : ordersNoteList) {
            OrderNote orderNote = (OrderNote) orderNotes;

            String nameGroups = orderNote.getGroupNotes().getNoteGroups().getName();
            String note = orderNote.getGroupNotes().getNotes().getNote();
            long id = orderNote.getGroupNotes().getNotes().getId();

            Set<UserDepartment> userDepartments = orderNote.getGroupNotes().getNotes().getUsers().getUserDepartments();

            Iterator<UserDepartment> iterator = userDepartments.iterator();
            String employeesName = "";
            while (iterator.hasNext()) {
                UserDepartment userDepartment = iterator.next();
                employeesName = userDepartment.getEmployees().getFirstName() + " " + userDepartment.getEmployees().getLastName();
            }

            OrderNoteRest orderNoteRest = new OrderNoteRest(id, nameGroups, note, employeesName);
            orderNotesRestList.add(orderNoteRest);
        }

        return orderNotesRestList;
    }
}
