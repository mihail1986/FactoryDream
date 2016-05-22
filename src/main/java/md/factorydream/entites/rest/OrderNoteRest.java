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

    private String nameGroups;
    private String note;

    public OrderNoteRest(String nameGroups, String note) {
        this.nameGroups = nameGroups;
        this.note = note;
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

}
