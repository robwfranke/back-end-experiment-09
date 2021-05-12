package nl.lotrac.bv.service;


import nl.lotrac.bv.exceptions.NameExistsException;
import nl.lotrac.bv.exceptions.RecordNotFoundException;
import nl.lotrac.bv.model.Customer;
import nl.lotrac.bv.model.Order;
import nl.lotrac.bv.repository.OrderRepository;
import nl.lotrac.bv.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{


    @Autowired
    private OrderRepository orderRepository;


    @Override
    public String createNewOrder(Order order) {


        System.out.println("OrderService Impl create newOrder");

//        if (orderRepository.getCustomerByCustomername(customer.getCustomername()) != null)
        if (orderRepository.getOrderByOrdername(order.getOrdername()) != null)
            throw new NameExistsException("order exists");
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);


        Order newOrder = orderRepository.save(order);
        return (newOrder.getOrdername());

    }






    @Override
    public List<Order> getOrders(){

        return orderRepository.findAll();
    }


    @Override
    public Optional<Order> getOrderById(long id) {
        if (!orderRepository.existsById(id)) throw new RecordNotFoundException();
        return orderRepository.findById(id);
    }



}
