package nl.lotrac.bv.service;

import nl.lotrac.bv.model.Order;

import java.util.List;

public interface OrderService {

    String createNewOrder(Order order);


    public abstract List<Order> getAllOrders();



    public abstract Order getOneOrderByID(Long id);



    //    in repository getOrderByOrdername
    public abstract Order getOneOrderByName(String order);



}
