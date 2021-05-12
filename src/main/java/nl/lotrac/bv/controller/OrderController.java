package nl.lotrac.bv.controller;

import nl.lotrac.bv.model.Customer;
import nl.lotrac.bv.model.Order;
import nl.lotrac.bv.model.MessageFrontEnd;
import nl.lotrac.bv.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.PublicKey;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/orders")


public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping(value="/create")
    public ResponseEntity<Object>createNewOrder(@RequestBody Order order){

        System.out.println("OrderController, createNewOrder");

        String newOrderName= orderService.createNewOrder(order);

        MessageFrontEnd message = new MessageFrontEnd("Order: " + newOrderName+ "  created");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ordername}")
                .buildAndExpand(newOrderName).toUri();

        return ResponseEntity.created(location).body(message);
    }




    @GetMapping(value = "")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.ok().body(orderService.getOrders());
    }





    @GetMapping(value = "/{id}")
    public ResponseEntity<Order>getOneOrderByID(@PathVariable("id")Long id){
        return new ResponseEntity<>(orderService.getOneOrderByID(id), HttpStatus.OK) ;
    }






}