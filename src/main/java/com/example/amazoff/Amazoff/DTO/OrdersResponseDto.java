package com.example.amazoff.Amazoff.DTO;

import com.example.amazoff.Amazoff.Model.DeliveryPartner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

@Builder
@Data
public class OrdersResponseDto {
    int id;
    LocalTime DeliveryTime;
    DeliveryPartner deliveryPartner;
}
