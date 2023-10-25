package com.example.amazoff.Amazoff.Controller;


import com.example.amazoff.Amazoff.Model.DeliveryPartner;
import com.example.amazoff.Amazoff.Model.Order;
import com.example.amazoff.Amazoff.Service.DeliveryPartnerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("delivery")
public class DeliveryPartnerController {

    @Autowired
    DeliveryPartnerServices deliveryPartnerServices;

    @PostMapping("/addDelivery")
    public DeliveryPartner addPartner(@RequestBody DeliveryPartner deliveryPartner){
        return deliveryPartnerServices.addDelivery(deliveryPartner);
    }

    @GetMapping("/get-partner-by-id/{id}")
    public DeliveryPartner getPartnerById(@PathVariable  int id){
        return deliveryPartnerServices.getPartnerById(id);
    }
    @GetMapping("/get_order_count_by_partner_id/{id}")
        public int getCountOfOrders(@PathVariable int id){
        return deliveryPartnerServices.getCountOfOrders(id);
    }

    @GetMapping("/get_orders_by_partner_id/{id}")
        public List<Order> getAllOrdersbypartner(@PathVariable int id){
        return deliveryPartnerServices.getAllOrdersbypartner(id);

    }
    @GetMapping("/get-count-of-orders-left-after-given-time")
    public int unDelivered(@RequestParam(name = "localTime") String localTime,@RequestParam(name = "partnerId") int partnerId){
        LocalTime time=LocalTime.parse(localTime);
        return deliveryPartnerServices.unDelivered(time, partnerId);
    }
    @GetMapping("/get_last_delivery_time/{id}")
    public LocalTime get_last_delivery_time(int id){
        return deliveryPartnerServices.get_last_delivery_time(id);
    }
    @DeleteMapping("/deleteOne")
    public void deleteOne(int id){
        deliveryPartnerServices.deleteOnr(id);
    }

}
