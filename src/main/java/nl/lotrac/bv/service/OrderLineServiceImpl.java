package nl.lotrac.bv.service;


import nl.lotrac.bv.exceptions.NameNotFoundException;
import nl.lotrac.bv.model.Order;
import nl.lotrac.bv.model.OrderLine;
import nl.lotrac.bv.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class OrderLineServiceImpl implements OrderLineService{

    @Autowired
    private OrderLineRepository orderLineRepository;


    @Override
    public List<OrderLine> getAllOrderLines(){

        return orderLineRepository.findAll();
    }

    @Override
    public OrderLine getOneOrderLineByID(Long id) {

        System.out.println("OrderLineServiceImpl");
        Optional<OrderLine> orderLine = orderLineRepository.findById(id);
        if (orderLine.isEmpty()) {
            throw new NameNotFoundException("orderLine does not exists");
        } else {
            return orderLine.get();
        }
    }


    //    In repository staat getOrderLineByKoekoek
    @Override
    public OrderLine getOneOrderLineByName(String itemname) {

        OrderLine orderLine=orderLineRepository.getOrderLineByKoekoek(itemname);
        return orderLine;
    }




}
