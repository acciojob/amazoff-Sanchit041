package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {

        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        String HH = deliveryTime.substring(0,2);
        String MM = deliveryTime.substring(3);
        this.deliveryTime = Integer.parseInt(HH)*60+Integer.parseInt(MM);
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
