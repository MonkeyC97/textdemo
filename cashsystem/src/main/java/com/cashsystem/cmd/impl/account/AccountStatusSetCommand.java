package com.cashsystem.cmd.impl.account;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.common.AccountStatus;
import com.cashsystem.common.AccountType;
import com.cashsystem.entity.Account;

import java.util.List;

@CommandMeta(
        name = "QTZH",
        desc = "启停账号",
        group = "账号信息"
)
@AdminCommand
public class AccountStatusSetCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("所有账户");
        List<Account> list = accountService.queryAllAccount();
        if(list.isEmpty()){
            System.out.println("没有账户");
        }else{
            for(Account account:list){
                System.out.println(account);
            }
        }
        printlnInfo("请输入要操作的账户编号");
        int id = scanner.nextInt();
        Account account = accountService.getAccountById(id);
        printlnInfo("请设置该账户的账号状态，1:管理员,2:用户");
        account.setAccountType(AccountType.valueof(scanner.nextInt()));
        printlnInfo("请设置该账户的账号状态,1:启用,2:停用");
        account.setAccountStatus(AccountStatus.valueof(scanner.nextInt()));
        if(accountService.updateAccount(account)){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }
}
