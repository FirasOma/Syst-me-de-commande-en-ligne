package de.tekup.exercicetp.services;

import de.tekup.exercicetp.entities.Order;
import de.tekup.exercicetp.entities.OrderDTO;
import de.tekup.exercicetp.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {


    private OrderRepository orderRepository;
    private ModelMapper mapper;

    public Order getOrder(int id){
        return orderRepository.findById(id).get();
    }

    public void AddOrder(OrderDTO orderdto){

      Order order = mapper.map(orderdto , Order.class);
      orderRepository.save(order);
    }


}
