package de.tekup.exercicetp.repositories;

import de.tekup.exercicetp.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {
    @Query(value = "SELECT DISTINCT d.name FROM delivery d JOIN (SELECT name,avg( DATEDIFF(delivery_date,shopping_date))" +
            " as moy from delivery group by name ORDER BY moy LIMIT 1) as moys  ON moys.name = d.name",
          nativeQuery = true)
         String LivreurRapide();

    @Query(value = "SELECT DISTINCT d.name FROM delivery d JOIN(SELECT name,avg( DATEDIFF(delivery_date,shopping_date))" +
            " as moy from delivery group by name ORDER BY  moy DESC LIMIT 1) as moys  ON moys.name = d.name;\n",
            nativeQuery = true)
    String LivreurLent();
}
