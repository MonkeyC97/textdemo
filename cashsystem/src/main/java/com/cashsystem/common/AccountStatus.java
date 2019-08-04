package com.cashsystem.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum  AccountStatus {

    UNLOCK(1,"启用"),LOCK(2,"启停");
    private int flag;
    private String desc;
    AccountStatus(int flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public static AccountStatus valueof(int flag){
        for(AccountStatus accountStatus:values()){
            if(accountStatus.flag == flag){
                return accountStatus;
            }
        }
        throw  new RuntimeException("accountStatus flag"+flag+"not fount");
    }
}
