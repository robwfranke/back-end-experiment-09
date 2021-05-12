package nl.lotrac.bv.service;

import nl.lotrac.bv.model.Order;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    public abstract List<Order> getOrders();



    public abstract Optional<Order> getOrderById(long id);


    String createNewOrder(Order order);

}
