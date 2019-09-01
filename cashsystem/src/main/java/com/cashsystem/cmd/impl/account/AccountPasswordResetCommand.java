package com.cashsystem.cmd.impl.account;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Account;

@CommandMeta(
        name = "CZMM",
        desc = "重置密码",
        group = "账号信息"
)
@AdminCommand
public class AccountPasswordResetCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("重置密码");
        System.out.println("请输入原密码");
        String oldPassword = scanner.next();
        Account account = accountService.getAccountBypassword(oldPassword);
        if(account != null){
            System.out.println("请输入新密码");
            String newPassword = scanner.next();
            System.out.println("请再次输入密码");
            String newPassword2 = scanner.next();
            if(newPassword.equals(newPassword2)){
               boolean effect = this.accountService.updatePassword(newPassword,subject.getAccount());
               if(effect){
                   subject.setAccount(account);
                   System.out.println("密码更新成功，请重新登录");
               }else{
                   System.out.println("密码更新失败，请联系管理员");
               }
            }else{
                System.out.println("两次密码输入不一致");
            }
        }else{
            System.out.println("密码输入错误，请重新尝试");
        }
    }
}
