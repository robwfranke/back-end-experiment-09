package nl.lotrac.bv.service;


import nl.lotrac.bv.exceptions.RecordNotFoundException;
import nl.lotrac.bv.model.Order;
import nl.lotrac.bv.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Collection<Order>getOrders(){
        return orderRepository.findAll();
    }


    @Override
    public Optional<Order> getOrderById(long id) {
        if (!orderRepository.existsById(id)) throw new RecordNotFoundException();
        return orderRepository.findById(id);
    }



}
