/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

/**
 *
 * @author Mihail.Cepraga
 */
public class OrderNotesRestValue {
    
    long groupNoteId;
    long noteId;
    String groupName;
    String noteValue;

    public OrderNotesRestValue(){}
    
    public OrderNotesRestValue(long groupNoteId, long noteId, String groupName, String noteValue) {
        this.noteId = noteId;
        this.groupName = groupName;
        this.noteValue = noteValue;
    }

    public long getGroupNoteId() {
        return groupNoteId;
    }

    public void setGroupNoteId(long groupNoteId) {
        this.groupNoteId = groupNoteId;
    }

    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getNoteValue() {
        return noteValue;
    }

    public void setNoteValue(String noteValue) {
        this.noteValue = noteValue;
    }

  
    
    
}
