package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public String addOrderPartnerPair(String orderId, String PartnerId) throws Exception
    {
        return orderRepository.addOrderPartnerPair(orderId,PartnerId);
    }

    public Order getOrderById(String orderId) throws Exception
    {
        return orderRepository.getOrderById(orderId);
    }
    public DeliveryPartner getPartnerById(String partnerId) throws Exception
    {
       return orderRepository.getPartnerById(partnerId);
    }
    public Integer getOrderCountByPartnerId(String partnerId) throws Exception
    {
      return  orderRepository.getOrderCountByPartnerId(partnerId);
    }
     public List<String> getOrdersByPartnerId(String partnerId) throws Exception
     {
         return orderRepository.getOrdersByPartnerId(partnerId);
     }
     public List<String> getAllOrders() throws Exception
     {
       return orderRepository.getAllOrders();
     }
      public Integer getCountOfUnassignedOrders()
      {
        return orderRepository.getCountOfUnassignedOrders();
      }
      public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time,String partnerId)throws Exception
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
       public String deleteOrderById(String OrderId)throws Exception
       {
           return  orderRepository.deleteOrderById(OrderId);
       }
}
