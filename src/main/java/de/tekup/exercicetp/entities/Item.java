package de.tekup.exercicetp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float weight;

    private String description;

    private float price;
    @OneToMany(mappedBy = "item")
    private List<OrderDetail> orderDetails;
}
