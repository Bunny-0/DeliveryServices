package com.example.amazoff.Amazoff.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    int id;
    @Column(name = "DeliveryTime",columnDefinition = "TIME")
    LocalTime DeliveryTime;
    @ManyToOne
    @JsonIgnore
    @JoinColumn
    DeliveryPartner deliveryPartner;
}
