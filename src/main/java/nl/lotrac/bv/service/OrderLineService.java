package nl.lotrac.bv.service;

import nl.lotrac.bv.model.Customer;
import nl.lotrac.bv.model.OrderLine;

import java.util.List;

public interface OrderLineService {

   public abstract List<OrderLine> getAllOrderLines();

   public abstract OrderLine getOneOrderLineByID(Long id);


}
