package com.cashsystem.entity;

import lombok.Data;

@Data
public class Goods {
    private Integer id;
    private String name;
    private String introceduce;
    private Integer stock;
    private String unit;
    private Integer price;
    private Integer discount;
}
