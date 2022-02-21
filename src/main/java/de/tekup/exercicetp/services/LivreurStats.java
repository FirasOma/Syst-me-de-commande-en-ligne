package de.tekup.exercicetp.services;

import de.tekup.exercicetp.entities.Delivery;
import de.tekup.exercicetp.repositories.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LivreurStats {

    private DeliveryRepository deliveryRepository;



    public String LivreurRapide(){
        return deliveryRepository.LivreurRapide();
    }

    public String LivreurLent(){
        return deliveryRepository.LivreurLent();
    }
}
