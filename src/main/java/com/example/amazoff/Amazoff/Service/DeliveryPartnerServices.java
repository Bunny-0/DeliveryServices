package com.example.amazoff.Amazoff.Service;

import com.example.amazoff.Amazoff.Model.DeliveryPartner;
import com.example.amazoff.Amazoff.Model.Order;

import java.time.LocalTime;
import java.util.List;

public interface DeliveryPartnerServices {


    public DeliveryPartner addDelivery(DeliveryPartner deliveryPartner);
    public DeliveryPartner getPartnerById(int id);
    public List<Order> getAllOrdersbypartner(int id);
    public int getCountOfOrders(int id);
    public int unDelivered(LocalTime localTime,int partnerId);
    public LocalTime get_last_delivery_time(int id);
    public void deleteOnr(int id);
}
