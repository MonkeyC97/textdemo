package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;
import org.omg.PortableInterceptor.INACTIVE;

import static sun.security.krb5.Confounder.intValue;

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
        int goodsId = scanner.nextInt();
        Goods goods = this.goodsService.getGoods(goodsId);
        if(goods == null){
            System.out.println("此编号商品不存在");
            return;//结束函数
        }else{
            System.out.println("商品的原信息如下");
            System.out.println(goods);
        }
        printlnInfo("请输入需要更新的商品简介");
        String introduce = scanner.next();

        printlnInfo("商品库存");
        int stock = scanner.nextInt();


        printlnInfo("请输入商品价格：单位：(元)，保留小数点两位");
        double priceDouble = scanner.nextDouble();
        int price = new Double(100 * priceDouble).intValue();

        System.out.println("请输入商品折扣,75表示75折");
        int discount = scanner.nextInt();


        System.out.println("请确认是否更新：y/n");
        String flag = scanner.next();
        if("y".equalsIgnoreCase(flag)){
            //更新数据库表：goods
            goods.setIntroduce(introduce);
            goods.setStock(stock);
            goods.setPrice(price);
            goods.setDiscount(discount);
           boolean effct =  this.goodsService.modifyGoods(goods);
           if(effct){
               System.out.println("商品更新成功");
           }else{
               System.out.println("商品更新失败");
           }
        }else{
            System.out.println(("你选择了不更新此商品"));
        }

    }
}
