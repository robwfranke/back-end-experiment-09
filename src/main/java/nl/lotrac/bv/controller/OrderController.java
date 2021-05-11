package nl.lotrac.bv.controller;


import nl.lotrac.bv.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/orders")


public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping(value = "")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.ok().body(orderService.getOrders());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(orderService.getOrderById(id));

    }



}