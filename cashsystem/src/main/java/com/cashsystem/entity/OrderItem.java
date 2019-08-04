package com.cashsystem.entity;

import com.sun.tools.corba.se.idl.InterfaceGen;
import lombok.Data;

@Data
public class OrderItem {
    private Integer id;
    private String orderId;
    private Integer goodsId;
    private String goodsName;
    private String goodsIntroduce;
    private Integer goodsNum;
    private String goodsUnit;
    private Integer goodsPrice;
    private Integer goodsDiscount;
}
