package com.cashsystem.cmd.impl.order;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.impl.AbstractCommand;

@CommandMeta(
        name = "LLDD",
        desc = "浏览订单",
        group = "订单信息"
)

@CustomerCommand
public class OrderBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

    }
}
