package com.cashsystem.common;

public enum AccountType {

    ADMIN(1,"管理员"),CUSTOMER(2,"客户");
    private int flag;
    private String desc;
    AccountType(int flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public static AccountType valueof(int flag){
        for(AccountType accountType:values()){
            if(accountType.flag == flag){
                return accountType;
            }
        }
        throw  new RuntimeException("accountStatus flag"+flag+"not fount");
    }

}
