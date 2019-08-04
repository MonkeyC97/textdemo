package com.cashsystem.cmd.impl;

import com.cashsystem.cmd.Command;
import com.cashsystem.service.AccountService;

public abstract class AbstractCommand implements Command {
    //启动所有的服务

    public AccountService accountService;
    public AbstractCommand(){
        this.accountService = new AccountService();
    }
}
