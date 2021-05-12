package nl.lotrac.bv.service;


import nl.lotrac.bv.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineServiceImpl implements OrderLineService{

    @Autowired
    private OrderLineRepository orderLineRepository;
}
