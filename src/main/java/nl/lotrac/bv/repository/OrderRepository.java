package nl.lotrac.bv.repository;

import nl.lotrac.bv.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long >{
}
