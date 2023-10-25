package com.example.amazoff.Amazoff.Service.Impl;

import com.example.amazoff.Amazoff.Model.DeliveryPartner;
import com.example.amazoff.Amazoff.Model.Order;
import com.example.amazoff.Amazoff.Repository.DeliveryPartnerRepository;
import com.example.amazoff.Amazoff.Service.DeliveryPartnerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryPartnerImpl implements DeliveryPartnerServices {


    @Autowired
    DeliveryPartnerRepository deliveryPartnerRepository;

    @Override
    public DeliveryPartner addDelivery(DeliveryPartner deliveryPartner) {
     DeliveryPartner deliveryPartner1=deliveryPartnerRepository.save(deliveryPartner);
     return deliveryPartner1;
    }

    @Override
    public DeliveryPartner getPartnerById(int id) {
        return deliveryPartnerRepository.findById(id).get();
    }

    @Override
    public List<Order> getAllOrdersbypartner(int id) {
        return deliveryPartnerRepository.findById(id).get().getOrders();
    }

    @Override
    public int getCountOfOrders(int id) {
        return deliveryPartnerRepository.findById(id).get().getOrders().size();
    }

    @Override
    public int unDelivered(LocalTime localTime ,int id) {
           return deliveryPartnerRepository.findById(id).get().getOrders().stream().filter(order -> order.getDeliveryTime().compareTo(localTime)>0).collect(Collectors.toList()).size();
    }

    @Override
    public LocalTime get_last_delivery_time(int id) {
        List<Order> order=deliveryPartnerRepository.findById(id).get().getOrders();
        LocalTime res= order.get(0).getDeliveryTime();
        for(Order temp:order){
            if(temp.getDeliveryTime().compareTo(res)>0){
                res=temp.getDeliveryTime();
            }
        }
        return res;
    }

    @Override
    public void deleteOnr(int id) {
        deliveryPartnerRepository.deleteById(id);
    }

}
