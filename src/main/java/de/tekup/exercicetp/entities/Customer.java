package de.tekup.exercicetp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue( strategy =GenerationType.IDENTITY)
    private int id;

    private String name;
    private String deliveryAddress;
    private String contact;
    private boolean active;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy ="customer")
    private List<Order> orders;
}
