/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

/**
 *
 * @author Zaițev.Victor
 */
public class DiametersValueRest {

    private short id;
    private String value;

    public DiametersValueRest(short id, String value) {
        this.id = id;
        this.value = value;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
