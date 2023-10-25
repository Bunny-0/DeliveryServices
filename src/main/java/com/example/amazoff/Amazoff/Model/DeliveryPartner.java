package com.example.amazoff.Amazoff.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "DeliveryPartner")
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String Name;

    @JsonIgnore
    @OneToMany(mappedBy = "deliveryPartner",cascade = CascadeType.ALL)
    List<Order> orders;
}
