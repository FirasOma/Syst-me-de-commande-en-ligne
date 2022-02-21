package de.tekup.exercicetp.services;

import de.tekup.exercicetp.entities.Item;
import de.tekup.exercicetp.entities.Order;
import de.tekup.exercicetp.entities.OrderDetail;
import de.tekup.exercicetp.repositories.ItemRepository;
import de.tekup.exercicetp.repositories.OrderDetailRepository;
import de.tekup.exercicetp.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CalculService {

    private OrderRepository orderRepository;

    public float CalculTotal(int id){
       Order order = orderRepository.findById(id).get();
       List<OrderDetail> orderDetails = order.getOrderdetail();
       float total =0;
        for (OrderDetail od: orderDetails ) {
            Item item = od.getItem();
            float x = item.getPrice();
            int y =  od.getQty();
            float z =  od.getTax();

          total =  x*y;
          total += total*(z/100);
        }
      return total;
    }
    public float CalculateWeight(int id){
        Order order = orderRepository.findById(id).get();
        List<OrderDetail> orderDetails = order.getOrderdetail();
        float weight =0;
        for (OrderDetail od:orderDetails) {
            Item item = od.getItem();
            float x = item.getWeight();
            int y =  od.getQty();
            weight = x*y;
        }
        return weight;
    }

}
