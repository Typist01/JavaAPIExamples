package com.sparta.actorsapi.actorsapi.controllers;

import com.sparta.actorsapi.actorsapi.dataobjects.Actor;
import com.sparta.actorsapi.actorsapi.dataobjects.Customer;
import com.sparta.actorsapi.actorsapi.services.SakilaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomersController {
    @Autowired
    SakilaDAO dao;

    @GetMapping("/customers/{id}")
    public Customer customerDetails(@PathVariable int id){
        try {
            return dao.getCustomer(id);
        } catch (Exception e) {
            System.out.println(" Error when connecting");
            throw new RuntimeException(e);
        }
    }
//    @GetMapping("/customers")
//    public Customer actorDetails

    @GetMapping("/customersAll")
    public List<Customer> allCustomers(){
        try {
            return dao.getAllCustomers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/customers")
    public Customer getCustomer(@RequestParam int customer_id){
        try {
            return dao.getCustomer(customer_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/customers/post")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void insertActor(@RequestBody Actor newActor){
        dao.addActor(newActor);
    }

    @PutMapping("/customers/put")
    public void replaceCustomer(@RequestBody ){
    }



}

