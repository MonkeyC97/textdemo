package com.cashsystem.cmd.impl;

import com.cashsystem.cmd.Command;
import com.cashsystem.cmd.Subject;
import com.cashsystem.entity.Goods;
import com.cashsystem.service.AccountService;
import com.cashsystem.service.GoodsService;

public abstract class AbstractCommand implements Command {
    //启动所有的服务

    public AccountService accountService;
    public GoodsService goodsService;
    public AbstractCommand(){
        this.accountService = new AccountService();
        this.goodsService = new GoodsService();
    }
    public void printlnInfo(String info){
        System.out.println(info);
    }
}
