/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Zaițev.Victor
 */
public class NoteGroupUpdateRest {

    @Min(1)
    private long noteId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String nameNoteGroup;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String descriptionNoteGroup;

    public NoteGroupUpdateRest(long noteId, String nameNoteGroup, String descriptionNoteGroup) {
        this.noteId = noteId;
        this.nameNoteGroup = nameNoteGroup;
        this.descriptionNoteGroup = descriptionNoteGroup;
    }

    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getNameNoteGroup() {
        return nameNoteGroup;
    }

    public void setNameNoteGroup(String nameNoteGroup) {
        this.nameNoteGroup = nameNoteGroup;
    }

    public String getDescriptionNoteGroup() {
        return descriptionNoteGroup;
    }

    public void setDescriptionNoteGroup(String descriptionNoteGroup) {
        this.descriptionNoteGroup = descriptionNoteGroup;
    }

}
