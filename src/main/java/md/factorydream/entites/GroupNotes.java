package md.factorydream.entites;
// Generated Apr 13, 2016 10:19:57 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * GroupNotes generated by hbm2java
 */
@Entity
@Table(name = "group_notes", schema = "public"
)

public class GroupNotes implements java.io.Serializable {

    private long id;
    private NoteGroups noteGroups;
    private Notes notes;
    private Users users;
    private Date lastUpdateDate;
    private Set<OrderNote> orderNotes = new HashSet<OrderNote>(0);

    public GroupNotes() {
    }

    public GroupNotes(long id, NoteGroups noteGroups, Notes notes, Users users) {
        this.id = id;
        this.noteGroups = noteGroups;
        this.notes = notes;
        this.users = users;
    }

    public GroupNotes(long id, NoteGroups noteGroups, Notes notes, Users users, Date lastUpdateDate, Set<OrderNote> orderNotes) {
        this.id = id;
        this.noteGroups = noteGroups;
        this.notes = notes;
        this.users = users;
        this.lastUpdateDate = lastUpdateDate;
        this.orderNotes = orderNotes;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group", nullable = false)
    public NoteGroups getNoteGroups() {
        return this.noteGroups;
    }

    public void setNoteGroups(NoteGroups noteGroups) {
        this.noteGroups = noteGroups;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_note", nullable = false)
    public Notes getNotes() {
        return this.notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_last_update", nullable = false)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", length = 29)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupNotes")
    @Cascade(CascadeType.ALL)
    public Set<OrderNote> getOrderNotes() {
        return this.orderNotes;
    }

    public void setOrderNotes(Set<OrderNote> orderNotes) {
        this.orderNotes = orderNotes;
    }

}
