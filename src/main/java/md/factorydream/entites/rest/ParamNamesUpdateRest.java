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
public class ParamNamesUpdateRest {

    @Min(1)
    private long id;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String name;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String paramNameDescription;

    public ParamNamesUpdateRest(long id, String name, String paramNameDescription) {
        this.id = id;
        this.name = name;
        this.paramNameDescription = paramNameDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParamNameDescription() {
        return paramNameDescription;
    }

    public void setParamNameDescription(String paramNameDescription) {
        this.paramNameDescription = paramNameDescription;
    }

}
