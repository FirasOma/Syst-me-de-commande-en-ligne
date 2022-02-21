package de.tekup.exercicetp.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private LocalDate shoppingDate;
    private LocalDate deliveryDate;

    @ManyToOne
    private Order order;
}
