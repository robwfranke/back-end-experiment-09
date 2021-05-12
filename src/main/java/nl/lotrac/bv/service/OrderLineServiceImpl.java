package nl.lotrac.bv.service;


import nl.lotrac.bv.model.OrderLine;
import nl.lotrac.bv.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService{

    @Autowired
    private OrderLineRepository orderLineRepository;


    @Override
    public List<OrderLine> getAllOrderLines(){

        return orderLineRepository.findAll();
    }

}
