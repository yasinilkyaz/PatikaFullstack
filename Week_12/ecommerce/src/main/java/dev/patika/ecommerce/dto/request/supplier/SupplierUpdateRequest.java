package dev.patika.ecommerce.dto.request.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SupplierUpdateRequest {

    @Positive
    private int id;
    private String address;
    @NotNull
    private String company;
    private String person;
    @Email
    private String mail;


    public SupplierUpdateRequest( int id,String address, String company, String person, String mail) {
        this.id=id;
        this.address = address;
        this.company = company;
        this.person = person;
        this.mail = mail;

    }
    public SupplierUpdateRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
