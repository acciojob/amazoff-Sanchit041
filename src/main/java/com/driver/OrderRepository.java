package com.driver;

import org.springframework.stereotype.Repository;

import java.beans.ExceptionListener;
import java.security.PublicKey;
import java.util.*;


public class OrderRepository {

    HashMap<String, Order> DBO = new HashMap<>();
    HashMap<String, DeliveryPartner> DBD = new HashMap<>();
    HashMap<String, List<String>> Pair_OD = new HashMap<>();

    public String addOrder(Order order) {
        if(DBO.containsKey(order.getId()))
        {
            return "";
        }
        DBO.put(order.getId(), order);
        return "Success";
    }

    public String addPartner(String  deliveryPartner) {
        DeliveryPartner db = new DeliveryPartner(deliveryPartner);
        DBD.put(deliveryPartner, db);
        return "Success";
    }

    public String addOrderPartnerPair(String orderId, String PartnerId) {
        boolean flag = false;
        for (String order : DBO.keySet()) {
            if (order.equals(orderId)) {
                flag = true;
            }
        }
        boolean flag2 = false;
        for (String partner : DBD.keySet()) {
            if (partner.equals(PartnerId)) {
                flag2 = true;
            }
        }
//        if (flag2 == false) throw new Exception("Partner is not Present Sorry");
        if (flag && flag2) {
            if(Pair_OD.containsKey(PartnerId))
            {
                List<String> ans = Pair_OD.get(PartnerId);
                for(int i=0;i<ans.size();i++)
                {
                    if(ans.get(i).equals(orderId))
                    {
                       return "";
                    }
                }
            }
            Pair_OD.put(PartnerId, Pair_OD.getOrDefault(PartnerId, new ArrayList<>()));
            Pair_OD.get(PartnerId).add(orderId);
            return "Success";
        }
//        throw new Exception("Order is Not present");
        return "";
    }

    public Order getOrderById(String orderId)  {
        if (!DBO.containsKey(orderId)) {
          return null;
        }
        return DBO.get(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        if (!DBD.containsKey(partnerId)) {
                 return null;
         }
        return DBD.get(partnerId);
    }

public Integer getOrderCountByPartnerId(String partnerId) {
        if (!Pair_OD.containsKey(partnerId)) {
            return 0;
        }
        return Pair_OD.get(partnerId).size();
    }

    public List<String> getOrdersByPartnerId(String partnerId)  {
        if (!Pair_OD.containsKey(partnerId)) {
            return new ArrayList<>();
        }
        List<Order> orderList = new ArrayList<>();
        List<String> OrderIdList = Pair_OD.get(partnerId);
        for (String orderId : OrderIdList) {
            orderList.add(DBO.get(orderId));
        }
        List<String> ans = new ArrayList<>();
        for(Order o : orderList)
        {
            ans.add(o.toString());
        }
        return ans;
    }

    public List<String> getAllOrders() {
        if (DBO.size() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        List<Order> order = new ArrayList<>(DBO.values());
        for(Order ord : order)
        {
            ans.add(ord.toString());
        }
        return ans;
    }

    public Integer getCountOfUnassignedOrders() {
        List<String> ans = new ArrayList<>();
        for (String partnerID : Pair_OD.keySet()) {
            ans.addAll(Pair_OD.get(partnerID));
        }
        return DBO.size() - ans.size();
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time,String partnerId) {
       if(!Pair_OD.containsKey(partnerId))
       {
         return 0;
       }
        List<String> ans = Pair_OD.get(partnerId);
        String HH = time.substring(0,2);
        String MM = time.substring(3);
        int Time = Integer.parseInt(HH)*60+Integer.parseInt(MM);
       int count=0;
       for(String orderID : ans)
       {
           if(DBO.get(orderID).getDeliveryTime()>Time)
           {
               count++;
           }
       }
        return count;
    }

    public String getLastDeliveryTimeByPartnerId(String PartnerId) {
        if(!DBD.containsKey(PartnerId))
        {
            return "";
        }
        if(Pair_OD.containsKey(PartnerId)) {
            return "";
        }
        List<String> ans = Pair_OD.get(PartnerId);
        int max = 0;
        for(String orderId:ans)
        {
            max = Math.max(max,DBO.get(orderId).getDeliveryTime());
        }
        int hh = max/60;
        int mm = max%60;
        String time =hh+":"+mm;
        return time;
    }

    public String deletePartnerById(String PartnerId) {
        if(!Pair_OD.containsKey(PartnerId))
        {
            return "";
        }
        Pair_OD.put(PartnerId,new ArrayList<>());
        return "Success";
    }

    public String deleteOrderById(String OrderId) {
       if(!DBO.containsKey(OrderId))
       {
//
           return "";
       }
        DBO.remove(OrderId);
        return "Success";
    }

}
