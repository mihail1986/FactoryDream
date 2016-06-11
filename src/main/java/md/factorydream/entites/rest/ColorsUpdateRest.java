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
public class ColorsUpdateRest {

    @Min(1)
    private short colorsId;

    @Min(1)
    private short statusCodeId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String value;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String colorsDescription;

    public ColorsUpdateRest(short colorsId, short statusCodeId, String value, String colorsDescription) {
        this.colorsId = colorsId;
        this.statusCodeId = statusCodeId;
        this.value = value;
        this.colorsDescription = colorsDescription;
    }

    public short getColorsId() {
        return colorsId;
    }

    public void setColorsId(short colorsId) {
        this.colorsId = colorsId;
    }

    public short getStatusCodeId() {
        return statusCodeId;
    }

    public void setStatusCodeId(short statusCodeId) {
        this.statusCodeId = statusCodeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColorsDescription() {
        return colorsDescription;
    }

    public void setColorsDescription(String colorsDescription) {
        this.colorsDescription = colorsDescription;
    }

}
