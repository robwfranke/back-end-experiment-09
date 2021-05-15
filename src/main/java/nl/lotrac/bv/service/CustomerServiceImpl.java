package nl.lotrac.bv.service;

import nl.lotrac.bv.exceptions.NameExistsException;
import nl.lotrac.bv.exceptions.NameNotFoundException;
import nl.lotrac.bv.model.Customer;
import nl.lotrac.bv.repository.CustomerRepository;
import nl.lotrac.bv.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public Customer createNewCustomer(Customer customer) {


        System.out.println("CustomerService Impl create newCustomer");

        if (customerRepository.getCustomerByCustomername(customer.getCustomername()) != null)
            throw new NameExistsException("customer exists");
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer;

    }




    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }



    @Override
    public Customer getOneCustomerByID(Long id) {

        System.out.println("CustomerServiceImpl");
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new NameNotFoundException("customer does not exists");
        } else {
            return customer.get();
        }
    }


    @Override
    public Customer getOneCustomerByName(String customername) {
        System.out.println("CustomerServiceImpl getOneCustomerByName");
        Customer customer = customerRepository.getCustomerByCustomername(customername);
        System.out.println("customer1");
        if (customer == null)
            throw new NameNotFoundException("customer does not exists");
        return customer;
    }




}
