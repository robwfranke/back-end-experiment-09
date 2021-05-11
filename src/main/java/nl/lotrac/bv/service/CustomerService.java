package nl.lotrac.bv.service;

import nl.lotrac.bv.model.Customer;

import java.util.List;


public interface CustomerService {


    public abstract List<Customer> getCustomers();

    public abstract Customer getCustomer(Long id);

    public abstract  String createNewCustomer(Customer customer);

    public abstract String getCustomerName(String customer);





//
//
//    public abstract String createUser(User user);
//
//    public abstract void updateUser(String username, User user);
//
//    public abstract void deleteUser(String username);
//    public abstract Collection<User> getUsers();
//   ;
//    public abstract Optional<User> getUser(String username);
//    public abstract boolean userExists(String username);
//
//    public abstract Collection<User> getAllAuthorities();
//    public abstract Set<Authority> getAuthorities(String username);
//    public abstract void addAuthority(String username, String authority);
//    public abstract void removeAuthority(String username, String authority);


}