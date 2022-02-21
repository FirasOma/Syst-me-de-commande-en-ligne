package de.tekup.exercicetp.services;

import de.tekup.exercicetp.entities.Customer;
import de.tekup.exercicetp.entities.Order;
import de.tekup.exercicetp.repositories.CustomerRepository;
import de.tekup.exercicetp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CalculService calculService;

    public Customer getCustomer(int id){
       return customerRepository.findById(id).get();
    }

    //@Query method
    public List<String> TopFiveCustomers(){
       return customerRepository.TopFiveCustomers();

    }
    //java api method
    public List<String> clientFidèle(){
        List<Order> orders = orderRepository.findAll();

        List<String> clientfidele = new ArrayList<>();
        List<Customer> customers = orders.stream().map(o -> o.getCustomer() ).distinct().collect(Collectors.toList());

       List<Customer> sortedCustomers = customers.stream().sorted(Comparator.comparing(c->c.getOrders().size()))
               .collect(Collectors.toList());
        Collections.reverse(sortedCustomers);
        int i = 0;
            for (Customer c : sortedCustomers) {
                if(i < 5)
                {clientfidele.add(c.getName());
                      i++;   }
            }
      return clientfidele;
    }

    public List<String> TopCustomersMoney(){
        List<Order> orders = orderRepository.findAll();
        List<Customer> customers = orders.stream().map(o->o.getCustomer()).distinct().collect(Collectors.toList());
        Map<String , Double> map = new HashMap();
        for (Customer c: customers) {
            map.put(c.getName(),c.getOrders().stream().mapToDouble(o->calculService.CalculTotal(o.getId())).sum());
        }

       Map<String, Double> sortedmap  = map.entrySet().stream().
               sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,
                       Map.Entry::getValue,
                       (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        List<String> loyalcustomers = new ArrayList<>(sortedmap.keySet());
        Collections.reverse(loyalcustomers);
        List<String> topfive = new ArrayList<>();
        int i =0;
        for (String s: loyalcustomers) {
            if(i < 5){
                topfive.add (loyalcustomers.get(i));
                i++;
            }
        }

        return topfive;
    }

}
