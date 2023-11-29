package dev.patika.view;

import dev.patika.business.concrates.CustomerManager;
import dev.patika.dao.concrates.CustomerDao;
import dev.patika.entities.Customer;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CustomerManager customerManager=new CustomerManager(new CustomerDao());
       /*
        Customer customer=new Customer();
        customer.setName("Test Dersleri");
        customer.setMail("test@patika.dev");
        customer.setGender(Customer.GENDER.MALE);
        customer.setOnDate(LocalDate.now());

        customerManager.save(customer);
        */

        //Customer firstCustomer=customerManager.findById(1);
        //customerManager.deleteById(2);

        List<Customer> customerList=customerManager.findAll();
        System.out.println(customerList.toString());
    }
}
