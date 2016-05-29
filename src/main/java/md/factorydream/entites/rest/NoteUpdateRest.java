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
public class NoteUpdateRest {

    @NotNull
    @Min(1)
    private Long noteId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String noteConntent;

    public NoteUpdateRest(Long noteId, String noteConntent) {
        this.noteId = noteId;
        this.noteConntent = noteConntent;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getNoteConntent() {
        return noteConntent;
    }

    public void setNoteConntent(String noteConntent) {
        this.noteConntent = noteConntent;
    }

}
