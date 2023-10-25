package com.example.amazoff.Amazoff.Service;

import com.example.amazoff.Amazoff.DTO.OrdersResponseDto;
import com.example.amazoff.Amazoff.Model.Order;
import jdk.jshell.execution.LoaderDelegate;

import java.time.LocalTime;

public interface OrdersServices {

    public Order addOrder(Order order);

    public OrdersResponseDto pairOrderDelivery(int orderId, int deliveryId);
    public OrdersResponseDto getOrder(int id);
    public int unPairedCount();
    public void deleteOne(int id);

}
