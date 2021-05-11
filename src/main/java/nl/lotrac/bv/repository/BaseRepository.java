package nl.lotrac.bv.repository;

import nl.lotrac.bv.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Customer, Long> {



}