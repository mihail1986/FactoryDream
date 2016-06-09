/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

import java.util.Date;

/**
 *
 * @author Zaițev.Victor
 */
public class CustomersValueRest {

    private long value;
    private String label;

    public CustomersValueRest(long value, String label) {
        this.value = value;
        this.label = label;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
  

}
