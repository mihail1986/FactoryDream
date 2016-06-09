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
public class ModelsUpdateRest {

    @Min(1)
    private short modelsId;

    @Min(1)
    private short statusCodeId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String value;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String modelDescription;

    public ModelsUpdateRest(short modelsId, short statusCodeId, String value, String modelDescription) {
        this.modelsId = modelsId;
        this.statusCodeId = statusCodeId;
        this.value = value;
        this.modelDescription = modelDescription;
    }

    public short getModelsId() {
        return modelsId;
    }

    public void setModelsId(short modelsId) {
        this.modelsId = modelsId;
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

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

}
