package com.example.amazoff.Amazoff.Convertor;

import com.example.amazoff.Amazoff.DTO.OrdersResponseDto;
import com.example.amazoff.Amazoff.Model.Order;

public class OrderConvertor {

    public static OrdersResponseDto convertEntityToDto(Order order){
        return OrdersResponseDto.builder().deliveryPartner(order.getDeliveryPartner()).DeliveryTime(order.getDeliveryTime()).id(order.getId()).build();
    }
}
