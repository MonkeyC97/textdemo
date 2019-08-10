package com.cashsystem.dao;

import com.cashsystem.common.OrderStatus;
import com.cashsystem.entity.Order;
import com.cashsystem.entity.OrderItem;
import com.sun.tools.corba.se.idl.constExpr.Or;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends BaseDao{
    Connection connection = null;
    PreparedStatement preparedStatement = null;//预处理SQL命令
    public boolean commitOrder(Order order){
        try{
            connection = this.getConnection(false);
            String insertOrderSql = "insert into `order`" +
                    "(id, account_id, create_time, finish_time, " +
                    "actual_amount, total_money, order_status, " +
                    "account_name) values (?,?,now(),now(),?,?,?,?)";
            String insertOrderItemSql = "insert into order_item(order_id, goods_id, goods_name," +
                    "goods_introduce, goods_num, goods_unit, goods_price, goods_discount) values (?,?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(insertOrderSql);

            preparedStatement.setString(1,order.getId());
            preparedStatement.setInt(2,order.getAccount_id());
            preparedStatement.setInt(3,order.getActual_amount());
            preparedStatement.setInt(4,order.getTotal_money());
            preparedStatement.setInt(5,order.getOrder_status().getFlag());
            preparedStatement.setString(6,order.getAccount_name());

            //更新数据库
            if (preparedStatement.executeUpdate() == 0){
                throw new RuntimeException("插入订单失败");
            }
            //开始插入订单项
            preparedStatement = connection.prepareStatement(insertOrderItemSql);
            for(OrderItem orderItem : order.orderItemList){
                preparedStatement.setString(1,orderItem.getOrderId());
                preparedStatement.setInt(2,orderItem.getGoodsId());
                preparedStatement.setString(3,orderItem.getGoodsName());
                preparedStatement.setString(4,orderItem.getGoodsIntroduce());
                preparedStatement.setInt(5,orderItem.getGoodsNum());
                preparedStatement.setString(6,orderItem.getGoodsUnit());
                preparedStatement.setInt(7,orderItem.getGoodsPrice());
                preparedStatement.setInt(8,orderItem.getGoodsDiscount());
                //将每一项preparedStatement缓存好
                preparedStatement.addBatch();
            }
            //批量操作数据库
            int[] effects = preparedStatement.executeBatch();
            for(int i:effects){
                if (i == 0){
                    throw new RuntimeException("插入订单明细失败");
                }
            }
            //手动提交事务
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(connection != null){
                try {
                    //进行回滚
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return true;
    }

    public List<Order> queryOrderByAccount(Integer accountId){
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;//预处理SQL命令
        ResultSet resultSet = null;
        try{
            connection = this.getConnection(false);
            String sql = this.getSql("@query_order_by_account");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,accountId);

            resultSet = preparedStatement.executeQuery();

            Order order = null;

            while(resultSet.next()){
                if(order == null){
                    order = new Order();
                    this.extractOrder(order,resultSet);
                    orderList.add(order);
                }
                //拿到了当前的orderid
                String orderId = resultSet.getString("order_id");
                //只有当订单信息不同的时候，我们才会生成一个订单
                //订单对象只有一个因为其中包含了很多的订单信息
                //如果为每一个订单信息都生成一个订单是不合理的
                if(!orderId.equals(order.getId())){
                    order = new Order();
                    this.extractOrder(order,resultSet);
                    orderList.add(order);
                }

                OrderItem orderItem = this.extractOrderOrderItem(resultSet);
                order.getOrderItemList().add(orderItem);

            }
        }catch (Exception e){
            e.printStackTrace();
            if(connection != null){
                try{
                    connection.rollback();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        }
        return orderList;
    }

    public void extractOrder(Order order,ResultSet resultSet) throws SQLException {
        order.setId(resultSet.getString("order_id"));
        order.setAccount_id(resultSet.getInt("account_id"));
        order.setAccount_name(resultSet.getString("account_name"));
        order.setCreate_time(resultSet.getTimestamp("create_time").toLocalDateTime());
        Timestamp finishTime = resultSet.getTimestamp("finish_time");
        if (finishTime != null) {
            order.setFinish_time(finishTime.toLocalDateTime());
        }
        order.setActual_amount(resultSet.getInt("actual_amount"));
        order.setTotal_money(resultSet.getInt("total_money"));
        order.setOrder_status(OrderStatus.valueof(resultSet.getInt("order_status")));

    }

    private OrderItem extractOrderOrderItem(ResultSet resultSet) throws Exception {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(resultSet.getInt("item_id"));
            orderItem.setGoodsId(resultSet.getInt("goods_id"));
            orderItem.setGoodsName(resultSet.getString("goods_name"));
            orderItem.setGoodsIntroduce(resultSet.getString("goods_introduce"));
            orderItem.setGoodsNum(resultSet.getInt("goods_num"));
            orderItem.setGoodsUnit(resultSet.getString("goods_unit"));
            orderItem.setGoodsPrice(resultSet.getInt("goods_price"));
            orderItem.setGoodsDiscount(resultSet.getInt("goods_discount"));
            return orderItem;
    }

    public String getSql(String sqlName) {
        System.out.println("=====sqlName:"+sqlName);
        //InputStream 是字节流
        try (InputStream in = this.getClass()
                .getClassLoader()
                //这个方法是用来获取配置文件的，方法传入的参数是一个路径
                .getResourceAsStream("script/" + sqlName.substring(1) + ".sql");
             // 从1 开始提取的原因是：sqlName: @query_order_by_account 去掉@符号
        ) {
            if (in == null) {
                throw new RuntimeException("load sql " + sqlName + " failed");
            } else {
                //InputStreamReader :字节流 通向字符流的桥梁
                try (InputStreamReader isr = new InputStreamReader(in);
                     //BufferedReader -> 从字符输入流中读取文本并缓冲字符
                     BufferedReader reader = new BufferedReader(isr)) {

                    StringBuilder stringBuilder = new StringBuilder();

                    stringBuilder.append(reader.readLine());

                    String line;
                    while (( line = reader.readLine()) != null) {
                        stringBuilder.append(" ").append(line);
                    }

                    //System.out.println("value:" + stringBuilder.toString());
                    return stringBuilder.toString();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("load sql " + sqlName + " failed");
        }
    }
}
