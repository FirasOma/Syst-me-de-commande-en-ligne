package de.tekup.exercicetp.repositories;

import de.tekup.exercicetp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value ="SELECT name FROM customer JOIN (SELECT customer_id, COUNT(*) as o FROM `order_customer` GROUP BY customer_id ORDER BY o DESC LIMIT 5 )" +
            " as tab ON customer.id = tab.customer_id ;",
    nativeQuery = true)
    List<String> TopFiveCustomers();

}
