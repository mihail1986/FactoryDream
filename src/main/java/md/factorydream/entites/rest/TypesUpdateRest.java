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
public class TypesUpdateRest {

    @Min(1)
    private short typesId;

    @Min(1)
    private short statusCodeId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String value;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String typeDescription;

    public TypesUpdateRest(short typesId, short statusCodeId, String value, String typeDescription) {
        this.typesId = typesId;
        this.statusCodeId = statusCodeId;
        this.value = value;
        this.typeDescription = typeDescription;
    }

    public short getTypesId() {
        return typesId;
    }

    public void setTypesId(short typesId) {
        this.typesId = typesId;
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

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    @Override
    public String toString() {
        return "TypesUpdateRest{" + "typesId=" + typesId + ", statusCodeId=" + statusCodeId + ", value=" + value + ", typeDescription=" + typeDescription + '}';
    }

}
