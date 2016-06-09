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
public class CustomersInsertRest {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String name;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String address;

    @NotNull
    @Pattern(regexp = "([\\+(]?(\\d){2,}[)]?[- \\.]?(\\d){2,}[- \\.]?(\\d){2,}[- \\.]?(\\d){2,}[- \\.]?(\\d){2,})|([\\+(]?(\\d){2,}[)]?[- \\.]?(\\d){2,}[- \\.]?(\\d){2,}[- \\.]?(\\d){2,})|([\\+(]?(\\d){2,}[)]?[- \\.]?(\\d){2,}[- \\.]?(\\d){2,})")
    private String phone;

    @NotNull
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String customerDescription;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\s\"\'\\,\\!]*$}")
    private String note;

    public CustomersInsertRest(String name, String address, String phone, String email, String customerDescription, String note) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.customerDescription = customerDescription;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerDescription() {
        return customerDescription;
    }

    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
