/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.Date;
import java.util.List;
import md.factorydream.entites.Notes;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.NoteUpdateRest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class NotesDAOImpl extends AbstractSpringDao implements NotesDAO {

    @Override
    public void save(Notes notes) {
        super.saveOrUpdate(notes);
    }

    @Override
    public List findAll() {
        return super.findAll(Notes.class);
    }

    @Override
    public boolean update(NoteUpdateRest noteUpdateRest, Users users) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery(" UPDATE notes SET "
                + "          id_user_last_update  = :user, "
                + "          note                 = :note, "
                + "          last_update_date     = :lastUpdateDate "
                + "       WHERE id = :id");

        query.setLong("id", noteUpdateRest.getNoteId());
        query.setString("note", noteUpdateRest.getNoteConntent());
        query.setInteger("user", users.getId());
        query.setTimestamp("lastUpdateDate", new Date());

        int result = query.executeUpdate();

        if (result <= 0) {
            return false;
        }

        return true;
    }

    @Override
    public void delete(Long noteId) {

        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(" from Notes notes where notes.id =:NoteId ");
        query.setLong("NoteId", noteId);

        List list = query.list();

        if (list != null && list.size() > 0) {
            Notes notes = (Notes) list.get(0);
            session.delete(notes);
        }

    }

}
