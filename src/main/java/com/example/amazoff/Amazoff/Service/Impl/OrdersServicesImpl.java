package com.example.amazoff.Amazoff.Service.Impl;

import com.example.amazoff.Amazoff.Convertor.OrderConvertor;
import com.example.amazoff.Amazoff.DTO.OrdersResponseDto;
import com.example.amazoff.Amazoff.Model.DeliveryPartner;
import com.example.amazoff.Amazoff.Model.Order;
import com.example.amazoff.Amazoff.Repository.DeliveryPartnerRepository;
import com.example.amazoff.Amazoff.Repository.OrderRepository;
import com.example.amazoff.Amazoff.Service.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.stream.Collectors;


@Service
public class OrdersServicesImpl implements OrdersServices {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    DeliveryPartnerRepository deliveryPartnerRepository;


    @Override
    public Order addOrder(Order order) {
        Order order1=orderRepository.save(order);
        return order1;
    }

    @Override
    public OrdersResponseDto pairOrderDelivery(int orderId, int deliveryId) {
        Order order=orderRepository.findById(orderId).get();
        DeliveryPartner deliveryPartner=deliveryPartnerRepository.findById(deliveryId).get();
        order.setDeliveryPartner(deliveryPartner);
        orderRepository.save(order);
        return OrdersResponseDto.builder().deliveryPartner(order.getDeliveryPartner()).DeliveryTime(order.getDeliveryTime()).id(order.getId()).build();

    }

    @Override
    public OrdersResponseDto getOrder(int id) {
        return OrderConvertor.convertEntityToDto(orderRepository.findById(id).get());

    }

    @Override
    public int unPairedCount() {
        int unpaired=orderRepository.findAll().stream().filter(order -> order.getDeliveryPartner()==null).collect(Collectors.toList()).size();
        return unpaired;
    }

    @Override
    public void deleteOne(int id) {
        orderRepository.deleteById(id);
    }


}
