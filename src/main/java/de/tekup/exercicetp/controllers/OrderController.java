package de.tekup.exercicetp.controllers;

import de.tekup.exercicetp.entities.Order;
import de.tekup.exercicetp.entities.OrderDTO;
import de.tekup.exercicetp.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class OrderController {


    private OrderService orderService;

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable int id){

        return orderService.getOrder(id);
    }

    @PostMapping("/orders/add")
    public void AddOrder(@RequestBody @Valid OrderDTO orderdto){
     orderService.AddOrder(orderdto);
    }
}
