package com.cashsystem.cmd.impl.account;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Account;

import java.util.List;

@CommandMeta(
        name = "CKZH",
        desc = "查看账户",
        group = "账号信息"
)
@AdminCommand
public class AccountBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("查看账户");
        List<Account> list = this.accountService.queryAllAccount();
        if(list.isEmpty()){
            System.out.println("账户为空");
        }else{
            for(Account account : list){
                System.out.println(account);
            }
        }
    }
}
