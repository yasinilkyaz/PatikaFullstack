package dev.patika.ecommerce.dto.request.supplier;

import dev.patika.ecommerce.entities.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class SupplierSaveRequest {

    private String address;
    @NotNull
    private String company;
    private String person;
    @Email
    private String mail;


    public SupplierSaveRequest( String address, String company, String person, String mail) {

        this.address = address;
        this.company = company;
        this.person = person;
        this.mail = mail;

    }
    public SupplierSaveRequest() {
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }


}
