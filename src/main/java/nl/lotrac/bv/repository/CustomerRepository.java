package nl.lotrac.bv.repository;

import nl.lotrac.bv.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getCustomerByCustomername(String customerName);

}
