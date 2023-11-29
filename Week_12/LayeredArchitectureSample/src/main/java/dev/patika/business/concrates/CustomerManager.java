package dev.patika.business.concrates;

import dev.patika.business.abstracts.ICustomerService;
import dev.patika.dao.abstracts.ICustomerDao;
import dev.patika.entities.Customer;

import java.util.List;

public class CustomerManager implements ICustomerService {

    private final ICustomerDao CustomerDao;

    public CustomerManager(ICustomerDao iCustomerDao) {
        this.CustomerDao = iCustomerDao;
    }

    @Override
    public void save(Customer customer) {
        Customer checkMailCustomer = this.CustomerDao.findByMail(customer.getMail());
        if (checkMailCustomer != null) {
            throw new RuntimeException(customer.getMail() + " bu e-posta adresi daha önce eklenmiş");
        }
        this.CustomerDao.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.CustomerDao.findById(id);
    }

    @Override
    public void update(Customer customer) {
        Customer checkMailCustomer = this.CustomerDao.findByMail(customer.getMail());
        if (checkMailCustomer != null && checkMailCustomer.getId() == customer.getId()) {
            throw new RuntimeException(customer.getMail() + " bu e-posta adresi daha önce eklenmiş");
        }
        this.CustomerDao.update(customer);
    }

    @Override
    public void deleteById(int id) {
        this.CustomerDao.delete(this.findById(id));
    }

    @Override
    public List<Customer> findAll() {
        return this.CustomerDao.findAll();
    }
}
