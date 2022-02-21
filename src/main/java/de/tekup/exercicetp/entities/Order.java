package de.tekup.exercicetp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "order_customer")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate createDate;
    @ManyToOne
    @JsonManagedReference
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderdetail;


    @Enumerated(EnumType.STRING)
    private OrderStatus status;

   /* public void setStatus(int i) {
        switch (i){
            case 0 :
               this.status = OrderStatus.CREATE;
             break;
            case 1 :
              this.status = OrderStatus.SHIPPING;
             break;
            case 2 :
                this.status = OrderStatus.DELIVERED;
                break;
            case 3 :
                this.status = OrderStatus.PAID;
                break;
        }
    }*/
}
