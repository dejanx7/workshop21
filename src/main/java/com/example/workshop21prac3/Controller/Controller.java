package com.example.workshop21prac3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop21prac3.Model.Customer;
import com.example.workshop21prac3.Model.Order;
import com.example.workshop21prac3.Repository.CustomerRepo;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping(path = "/api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomer(@RequestParam(defaultValue = "10") Integer limit, @RequestParam(defaultValue = "0") Integer offset){

        return ResponseEntity.ok(customerRepo.getAllCustomers(offset, limit));

    }

    @GetMapping(path = "/api/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id){

        return ResponseEntity.ok(customerRepo.getCustomerById(id));

    }

    @GetMapping(path = "api/customers/{id}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable String id){

        return ResponseEntity.ok(customerRepo.getOrdersByCustomerId(id));    }


    
}
