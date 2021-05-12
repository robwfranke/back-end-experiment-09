package nl.lotrac.bv.controller;

import nl.lotrac.bv.model.OrderLine;
import nl.lotrac.bv.model.MessageFrontEnd;
import nl.lotrac.bv.service.OrderLineService;
import nl.lotrac.bv.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


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

}
