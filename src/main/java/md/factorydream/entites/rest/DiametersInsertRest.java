/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Zaițev.Victor
 */
public class DiametersInsertRest {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String value;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String diameterDescription;

    public DiametersInsertRest(String value, String diameterDescription) {
        this.value = value;
        this.diameterDescription = diameterDescription;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDiameterDescription() {
        return diameterDescription;
    }

    public void setDiameterDescription(String diameterDescription) {
        this.diameterDescription = diameterDescription;
    }

}
