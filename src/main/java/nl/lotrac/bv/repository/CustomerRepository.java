package nl.lotrac.bv.repository;

import nl.lotrac.bv.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getCustomerByCustomername(String customername);


}
