package nl.lotrac.bv.controller;

import nl.lotrac.bv.model.OrderLine;
import nl.lotrac.bv.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/orderlines")

public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;


    @GetMapping(value = "")
    public ResponseEntity<Object> getAllOrderLines() {

        return ResponseEntity.ok().body(orderLineService.getAllOrderLines());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderLine>getOneOrderLineByID(@PathVariable("id")Long id){
        return new ResponseEntity<>(orderLineService.getOneOrderLineByID(id),HttpStatus.OK) ;
    }



//    In repository staat getOrderLineByKoekoek

    @GetMapping(value = "/name/{ordername}")
    public ResponseEntity<Object> getOneOrderLineByName(@PathVariable("ordername") String ordername) {
        return ResponseEntity.ok().body(orderLineService.getOneOrderLineByName(ordername));
    }





}
