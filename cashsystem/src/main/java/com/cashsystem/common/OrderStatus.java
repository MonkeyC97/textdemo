package com.cashsystem.common;

public enum OrderStatus {
    PLAYING(1,"待支付"),OK(2,"支付完成");
    private int flag;
    private String desc;
    OrderStatus(int flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public OrderStatus valueof(int flag){
        for(OrderStatus orderStatus:values()){
            if(orderStatus.flag == flag){
                return orderStatus;
            }
        }
        throw  new RuntimeException("accountStatus flag"+flag+"not fount");
    }
}
