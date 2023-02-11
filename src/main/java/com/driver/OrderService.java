package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;


public class OrderService {

    OrderRepository orderRepository = new OrderRepository();
    public String addOrder(Order order)
    {
      return orderRepository.addOrder(order);
    }
    public String addPartner(String deliveryPartner)
    {
      return orderRepository.addPartner(deliveryPartner);
    }

    public String addOrderPartnerPair(String orderId, String PartnerId) {
        return orderRepository.addOrderPartnerPair(orderId,PartnerId);
    }

    public Order getOrderById(String orderId)     {
        return orderRepository.getOrderById(orderId);
    }
    public DeliveryPartner getPartnerById(String partnerId)
    {
       return orderRepository.getPartnerById(partnerId);
    }
    public Integer getOrderCountByPartnerId(String partnerId)
    {
      return  orderRepository.getOrderCountByPartnerId(partnerId);
    }
     public List<String> getOrdersByPartnerId(String partnerId)
     {
         return orderRepository.getOrdersByPartnerId(partnerId);
     }
     public List<String> getAllOrders()
     {
       return orderRepository.getAllOrders();
     }
      public Integer getCountOfUnassignedOrders()
      {
        return orderRepository.getCountOfUnassignedOrders();
      }
      public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time,String partnerId)
      {
          return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(time,partnerId);
      }
      public String getLastDeliveryTimeByPartnerId(String PartnerId)
      {
          return orderRepository.getLastDeliveryTimeByPartnerId(PartnerId);
      }
      public String deletePartnerById(String PartnerId)
      {
          return orderRepository.deletePartnerById(PartnerId);
      }
       public String deleteOrderById(String OrderId)
       {
           return  orderRepository.deleteOrderById(OrderId);
       }
}
