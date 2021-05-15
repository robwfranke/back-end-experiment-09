package nl.lotrac.bv.controller;

import nl.lotrac.bv.model.Customer;
import nl.lotrac.bv.model.MessageFrontEnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.lotrac.bv.service.CustomerService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController


public class BaseController {

    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "/")
    public String hello() {
        return "Hello World";
    }


    @PostMapping(value="/create")
   public ResponseEntity<Customer>createNewCustomer(@RequestBody Customer customer){

        System.out.println("BaseController, createNewCustomer");

        Customer newCustomername= customerService.createNewCustomer(customer);

//        MessageFrontEnd message = new MessageFrontEnd("Customer: " + newCustomername+ "  created");

//        hier adres op geven waar je customer kunt opvragen
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/customers/name/" + newCustomername.getCustomername())
                .buildAndExpand(newCustomername).toUri();

  return ResponseEntity.created(location).body(newCustomername);
    }

}
