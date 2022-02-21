package de.tekup.exercicetp.controllers;

import de.tekup.exercicetp.entities.Customer;
import de.tekup.exercicetp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    //@Query method
    @GetMapping("/customers/loyalones")
    public List<String> TopFiveCustomers(){
        return  customerService.TopFiveCustomers();
    }
    //Java api method
    @GetMapping("/customers/fidèles")
    public List<String> clientsFidèles(){
       return customerService.clientFidèle();
    }

    @GetMapping("/customers/money")
    public List<String> TopCustomers(){
        return customerService.TopCustomersMoney();
    }
}
