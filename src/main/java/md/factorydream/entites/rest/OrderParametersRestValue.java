/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

/**
 *
 * @author Mihail.Cepraga
 */
public class OrderParametersRestValue {
    
    private String paramName;
    private String paramValue;

    public OrderParametersRestValue(){}
    
    public OrderParametersRestValue(String paramName, String paramValue) {
        this.paramName = paramName;
        this.paramValue = paramValue;
    }
    
    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
