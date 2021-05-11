package nl.lotrac.bv.service;

import nl.lotrac.bv.exceptions.CustomernameNotPresentException;
import nl.lotrac.bv.model.Customer;

import nl.lotrac.bv.exceptions.RecordNotFoundException;
import nl.lotrac.bv.exceptions.CustomernameExistsException;

import nl.lotrac.bv.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import nl.lotrac.bv.utils.RandomStringGenerator;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


//    public boolean customerExists(String customername) {
//        return customerRepository.existsById(customername);
//    }


    @Override
    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerName(String customername) {
        System.out.println("CustomerServiceImpl getCustomerName");
        Customer customer = customerRepository.getCustomerByCustomername(customername);
        System.out.println("customer1");
        if (customer == null)
            throw new CustomernameNotPresentException("customer does not exists");

        return customer;


    }


    @Override
    public Customer getCustomer(Long id) {

        System.out.println("CustomerServiceImpl");
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new RecordNotFoundException();
        } else {
            return customer.get();
        }
    }


    @Override

    public String createNewCustomer(Customer customer) {


        System.out.println("CustomerService Impl create newCustomer");

        if (customerRepository.getCustomerByCustomername(customer.getCustomername()) != null)
            throw new CustomernameExistsException("customer exists");
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        customer.setApikey(randomString);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer newCustomer = customerRepository.save(customer);
        return (newCustomer.getCustomername());

    }


}
