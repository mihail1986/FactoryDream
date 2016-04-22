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
    
    private long paramId;
    private String paramName;
    private String paramValue;

    public OrderParametersRestValue(){}
    
    public OrderParametersRestValue(long paramId, String paramName, String paramValue) {
        this.paramId = paramId;
        this.paramName = paramName;
        this.paramValue = paramValue;
    }
    
    public long getParamId() {
        return paramId;
    }

    public void setParamId(long paramId) {
        this.paramId = paramId;
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
