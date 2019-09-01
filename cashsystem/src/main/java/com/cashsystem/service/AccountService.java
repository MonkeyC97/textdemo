package com.cashsystem.service;

import com.cashsystem.dao.AccountDao;
import com.cashsystem.entity.Account;

import java.util.List;

public class AccountService {
    private AccountDao accountDao;

    public AccountService(){
        this.accountDao = new AccountDao();
    }

    public Account login(String username,String password){
        return this.accountDao.login(username,password);
    }

    public boolean register(Account account){
        return this.accountDao.register(account);
    }

    public List<Account> queryAllAccount(){
        return this.accountDao.queryAllAccount();
    }

    public boolean updatePassword(String password,Account account){
        return this.accountDao.updatePassword(password,account);
    }

    public Account getAccountById(int id){
        return accountDao.getAccountById(id);
    }

    public boolean updateAccount(Account account){
        return accountDao.updateAccount(account);
    }
    public Account getAccountBypassword(String password){
        return accountDao.getAccountByPassword(password);
    }
}
