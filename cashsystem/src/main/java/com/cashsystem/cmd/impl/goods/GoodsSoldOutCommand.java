package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;

@CommandMeta(
        name = "XJSP",
        desc = "下架商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsSoldOutCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("下架商品");
        System.out.println("请输入下架商品编号");
        int goodsId = scanner.nextInt();
        Goods goods = this.goodsService.getGoods(goodsId);
        if(goods == null){
            printlnInfo("下架商品不存在");
        }else{
            System.out.println("下架商品如下：");
            System.out.println(goods);
            printlnInfo("确认是否下架(y/n yes/no)：");
            String anwser = scanner.next();
            if("y".equalsIgnoreCase(anwser) || "yes".equalsIgnoreCase(anwser)){
                boolean effect = this.goodsService.soldOutGoods(goodsId);
                if(effect){
                    System.out.println("商品下架成功");
                }else{
                    printlnInfo("商品下架失败，稍后重试");
                }
            }
        }
    }
}
