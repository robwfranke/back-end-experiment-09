package nl.lotrac.bv.service;

import nl.lotrac.bv.model.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderService {

    public abstract Collection<Order>getOrders();



    public abstract Optional<Order> getOrderById(long id);


}
