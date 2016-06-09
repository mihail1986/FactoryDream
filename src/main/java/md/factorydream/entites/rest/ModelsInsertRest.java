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
public class ModelsInsertRest {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String value;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String modelDescription;

    public ModelsInsertRest(String value, String modelDescription) {
        this.value = value;
        this.modelDescription = modelDescription;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

}
