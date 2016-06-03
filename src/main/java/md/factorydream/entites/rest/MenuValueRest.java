/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

import java.util.List;
import javax.persistence.Column;

/**
 *
 * @author Zaițev.Victor
 */
public class MenuValueRest {

    private List menuLabel;

    public MenuValueRest(List menuLabel) {
        this.menuLabel = menuLabel;
    }

    public List getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(List menuLabel) {
        this.menuLabel = menuLabel;
    }

}
