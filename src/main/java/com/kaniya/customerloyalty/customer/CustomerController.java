package com.kaniya.customerloyalty.customer;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getllcustomers")
    public List<Customer> getAllCustomers(){

        return customerService.getAllCustomers();
    }

    @PostMapping("/createcustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.createCustomer(customerRequest);
    }


}
