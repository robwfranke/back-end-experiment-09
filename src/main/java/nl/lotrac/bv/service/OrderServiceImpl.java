package nl.lotrac.bv.service;


import nl.lotrac.bv.exceptions.NameExistsException;
import nl.lotrac.bv.exceptions.NameNotFoundException;
import nl.lotrac.bv.exceptions.RecordNotFoundException;
import nl.lotrac.bv.model.Customer;
import nl.lotrac.bv.model.Order;
import nl.lotrac.bv.model.User;
import nl.lotrac.bv.repository.OrderRepository;
import nl.lotrac.bv.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;


    @Override
    public String createNewOrder(Order order) {
        var a =SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (orderRepository.getOrderByOrdername(order.getOrdername()) != null)
            throw new NameExistsException("order exists");
        order.setStatus("pending");
        Order newOrder = orderRepository.save(order);
        return (newOrder.getOrdername());
    }


    @Override
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    @Override
    public Order getOneOrderByID(Long id) {

        System.out.println("OrderServiceImpl");
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new NameNotFoundException("order does not exists");
        } else {
            return order.get();
        }
    }




    //    in repository getOrderByOrdername
    @Override
    public Order getOneOrderByName(String ordername) {
        System.out.println("OrderServiceImpl getOneOrderByName");
        Order order = orderRepository.getOrderByOrdername(ordername);
        System.out.println("order1");
        if (order == null)
            throw new NameNotFoundException("order does not exists");
        return order;
    }

//    public abstract void updateUser(String username, User user);


@Override
    public void updateOrder (String ordername, Order newOrder){
    System.out.println("ordername");
    Order order = orderRepository.getOrderByOrdername(ordername);

    if (order == null)
        throw new NameNotFoundException("order does not exists");



    order.setStatus(newOrder.getStatus());

    orderRepository.save(order);


}








}
