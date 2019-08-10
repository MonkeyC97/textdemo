package com.cashsystem.cmd.impl;

import com.cashsystem.cmd.Command;
import com.cashsystem.cmd.Subject;
import com.cashsystem.entity.Goods;
import com.cashsystem.service.AccountService;
import com.cashsystem.service.GoodsService;
import com.cashsystem.service.OrderService;

public abstract class AbstractCommand implements Command {
    //启动所有的服务

    public AccountService accountService;
    public GoodsService goodsService;
    public OrderService orderService;
    public AbstractCommand(){
        this.accountService = new AccountService();
        this.goodsService = new GoodsService();
        this.orderService = new OrderService();
    }
    public void printlnInfo(String info){
        System.out.println(info);
    }

}
