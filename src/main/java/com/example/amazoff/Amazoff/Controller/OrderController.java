package com.example.amazoff.Amazoff.Controller;

import com.example.amazoff.Amazoff.DTO.OrdersResponseDto;
import com.example.amazoff.Amazoff.Model.Order;
import com.example.amazoff.Amazoff.Repository.OrderRepository;
import com.example.amazoff.Amazoff.Service.OrdersServices;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {


    @Autowired
    OrdersServices ordersServices;

      @PostMapping("/addOrder")
        public Order addOrder(@RequestBody Order order){
           return ordersServices.addOrder(order);
        }
        @PostMapping("/pair/{OrderId}/{DeliveryId}")
            public OrdersResponseDto pairOrder_Delivery(@PathVariable int OrderId, @PathVariable int DeliveryId){
            return ordersServices.pairOrderDelivery(OrderId,DeliveryId);
        }

        @GetMapping("/{id}")
        public OrdersResponseDto getOrder(@PathVariable int id){
          return ordersServices.getOrder(id);

        }
        @GetMapping("/getUnassignedOrder")
        public int unPairedCount(){
          return ordersServices.unPairedCount();
        }
        @DeleteMapping("/deleteOneOrder")
        public void deleteOne(int id){
          ordersServices.deleteOne(id);
        }

}
