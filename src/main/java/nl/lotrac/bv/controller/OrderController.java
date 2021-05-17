package nl.lotrac.bv.controller;

import nl.lotrac.bv.model.MessageFrontEnd;
import nl.lotrac.bv.model.Order;
import nl.lotrac.bv.model.User;
import nl.lotrac.bv.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/orders")


public class OrderController {

    @Autowired
    private OrderService orderService;

// CUSTOMER, COMPANY_USER, ADMIN

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createNewOrder(@RequestBody Order order) {

        String newOrderName = orderService.createNewOrder(order);

        MessageFrontEnd message = new MessageFrontEnd("Order: " + newOrderName + "  created");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{create}")
                .buildAndExpand(newOrderName).toUri();

        return ResponseEntity.created(location).body(message);
    }


    @GetMapping(value = "/user_admin")
    public ResponseEntity<Object> getAllOrders() {

        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    //*************************************************************************************
//    @GetMapping(value = "/proef/{username}")
//    public ResponseEntity<Object> getOrdersC(@PathVariable("username") String username) {
//
//
//        List<Order> orders = orderService.getAllByUser(username);
//
//        return ResponseEntity.ok().body(orderService.getAllByUser());
        //*************************************************************************************


        @GetMapping(value = "/{id}")
        public ResponseEntity<Order> getOneOrderByID (@PathVariable("id") Long id){
            return new ResponseEntity<>(orderService.getOneOrderByID(id), HttpStatus.OK);
        }


//    in repository getOrderByOrdername

        @GetMapping(value = "/name/{ordername}")
        public ResponseEntity<Object> getOneOrderByName (@PathVariable("ordername") String ordername){
            return ResponseEntity.ok().body(orderService.getOneOrderByName(ordername));
        }


        @PutMapping(value = "/update/{ordername}")

        public ResponseEntity<Object> updateOrder (@PathVariable("ordername") String ordername, @RequestBody Order order)
        {
//public ResponseEntity<Object>updateOrder(@PathVariable("/update")String ordername, @RequestBody Order order){

            orderService.updateOrder(ordername, order);
            return ResponseEntity.noContent().build();

        }


    }