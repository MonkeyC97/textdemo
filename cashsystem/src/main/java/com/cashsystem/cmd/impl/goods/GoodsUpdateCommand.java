package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;
import org.omg.PortableInterceptor.INACTIVE;

@CommandMeta(
        name = "GXSP",
        desc = "更新商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsUpdateCommand extends  AbstractCommand{

    @Override
    public void execute(Subject subject) {
        System.out.println("更新商品");
        printlnInfo("请输入更新商品的编号");
        int goodsId = Integer.parseInt(scanner.nextLine());
        Goods goods = this.goodsService.getGoods(goodsId);

        if(goods == null){
            printlnInfo("没有此编号的货物");
            return;//结束函数
        }else{
            printlnInfo("商品的原信息如下");
            System.out.println(goods);
        }

        printlnInfo("请输入需要更新的商品简介");
        String introduce = scanner.next();

        printlnInfo("商品库存");
        int stock = scanner.nextInt();

        printlnInfo("商品单位：包，个，箱...");
        String unit = scanner.next();

        printlnInfo("请输入商品价格：单位：(元)，保留小数点两位");
        int price = new Double(100 * scanner.nextDouble()).intValue();

        System.out.println("请输入商品折扣,75表示75折");
        int discount = scanner.nextInt();


        printlnInfo("请确认是否更新：y/n");
        String flag = scanner.nextLine();
        if("y".equalsIgnoreCase(flag)){
            //更新数据库表：goods
            goods.setIntroduce(introduce);
            goods.setStock(stock);
            goods.setUnit(unit);
            goods.setPrice(stock);
            goods.setDiscount(discount);
           boolean effct =  this.goodsService.modifyGoods(goods);
           if(effct){
               printlnInfo("商品更新成功");
           }else{
               printlnInfo("商品更新失败");
           }
        }else{
            printlnInfo("你选择了不更新此商品");
        }

    }
}
