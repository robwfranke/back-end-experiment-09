package nl.lotrac.bv.service;

import nl.lotrac.bv.model.Customer;

import java.util.List;


public interface CustomerService {


    public abstract  String createNewCustomer(Customer customer);

    public abstract List<Customer> getAllCustomers();

    public abstract Customer getOneCustomerByID(Long id);


    public abstract Customer getOneCustomerByName(String customer);


}