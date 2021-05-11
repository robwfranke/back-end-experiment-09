package nl.lotrac.bv.controller;

import nl.lotrac.bv.model.Customer;
import nl.lotrac.bv.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// localhost 3000;
@CrossOrigin(origins = "*", maxAge=3600)
@RestController
@RequestMapping(value = "/customers")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    @GetMapping(value = "")
//    public ResponseEntity<Object> getMessage() {
//        return new ResponseEntity<>("SECURED REST endpoint: /customers", HttpStatus.OK);
//    }

    @GetMapping(value = "")

    public ResponseEntity<List<Customer>>getCustomers(){
        return ResponseEntity.ok().body(customerService.getCustomers());
    }




    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer>getOneCustomer(@PathVariable("id")Long id){
      return new ResponseEntity<>(customerService.getCustomer(id),HttpStatus.OK) ;
}

    @GetMapping(value = "/{customername}")
    public ResponseEntity<Object> getCustomerName(@PathVariable("customername") String customername) {
        return ResponseEntity.ok().body(customerService.getCustomerName(customername));
    }


}
