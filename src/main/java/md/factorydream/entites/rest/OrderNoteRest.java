/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

/**
 *
 * @author Zaițev.Victor
 */
public class OrderNoteRest {

    private long id;
    private String nameGroups;
    private String note;
    private String firstName;
    //"id":3,"nameGroups":"Customer","note":"Note 1.2 New note","firstName":"Victor Zaitev"}

    public OrderNoteRest(long id, String nameGroups, String note, String firstName) {
        this.id = id;
        this.nameGroups = nameGroups;
        this.note = note;
        this.firstName = firstName;
    }

    public String getNameGroups() {
        return nameGroups;
    }

    public void setNameGroups(String nameGroups) {
        this.nameGroups = nameGroups;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
