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
public class DiametersUpdateRest {

    @Min(1)
    private short diametersId;

    @Min(1)
    private short statusCodeId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String value;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String diametersDescription;

    public DiametersUpdateRest(short diametersId, short statusCodeId, String value, String diametersDescription) {
        this.diametersId = diametersId;
        this.statusCodeId = statusCodeId;
        this.value = value;
        this.diametersDescription = diametersDescription;
    }

    public short getDiametersId() {
        return diametersId;
    }

    public void setDiametersId(short diametersId) {
        this.diametersId = diametersId;
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

    public String getDiametersDescription() {
        return diametersDescription;
    }

    public void setDiametersDescription(String diametersDescription) {
        this.diametersDescription = diametersDescription;
    }

}
