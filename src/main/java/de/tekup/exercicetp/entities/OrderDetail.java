package de.tekup.exercicetp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int qty;
    private float tax;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Item item;

}
