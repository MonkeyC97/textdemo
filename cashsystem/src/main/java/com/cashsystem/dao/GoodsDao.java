package com.cashsystem.dao;

import com.cashsystem.entity.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class GoodsDao extends BaseDao{
    //浏览商品
    public List<Goods> quarryAllGoods(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//预处理SQL命令
        ResultSet resultSet = null;
        List<Goods> list = new ArrayList<>();
        try{
            connection = this.getConnection(true);
            String sql = "select id,name,introduce,stock,unit,price,discount" +
                    " from goods";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Goods goods = this.extractGoods(resultSet);
                if(goods != null){
                    list.add(goods);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return list;
    }

    public Goods extractGoods(ResultSet resultSet){
        Goods goods = new Goods();
        try {
            goods.setId(resultSet.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            goods.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            goods.setIntroduce(resultSet.getString("introduce"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            goods.setStock(resultSet.getInt("stock"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            goods.setUnit(resultSet.getString("Unit"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            goods.setPrice(resultSet.getInt("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            goods.setDiscount(resultSet.getInt("discount"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    //上架商品
    public boolean putAwayGoods(Goods goods){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//预处理SQL命令
        ResultSet resultSet = null;
        boolean effect = false;
        try{
            connection = this.getConnection(true);
            String sql = "insert into goods(name,introduce,stock,unit,price,discount)"+
                    "values(?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,goods.getName());
            preparedStatement.setString(2,goods.getIntroduce());
            preparedStatement.setInt(3,goods.getStock());
            preparedStatement.setString(4,goods.getUnit());
            preparedStatement.setInt(5,goods.getPrice());
            preparedStatement.setInt(6,goods.getDiscount());

            effect = (preparedStatement.executeUpdate()==1);
            resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                Integer id = resultSet.getInt(1);
                goods.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return effect;
    }
    //更新商品
    public Goods getGoods(int goodsId){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//预处理SQL命令
        ResultSet resultSet = null;
        Goods goods = new Goods();

        try{
            connection = this.getConnection(true);//自动提交
            String sql = "select id,name,introduce,stock,unit,price,discount from goods where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goodsId);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
               return this.extractGoods(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return null;
    }

    //更新商品
    public boolean modifyGoods(Goods goods){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean effect = false;

        try{
            connection = this.getConnection(true);
            String sql = "update goods set name =?,introduce =?,stock=?,unit=?,price=?,discount=?where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,goods.getName());
            preparedStatement.setString(2,goods.getIntroduce());
            preparedStatement.setInt(3,goods.getStock());
            preparedStatement.setString(4,goods.getUnit());
            preparedStatement.setInt(5,goods.getPrice());
            preparedStatement.setInt(6,goods.getDiscount());;
            preparedStatement.setInt(7,goods.getId());
            effect = (preparedStatement.executeUpdate() == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return effect;
    }

    //下架商品
    public boolean soldOutGoods(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean effect = false;
        try{
            connection = this.getConnection(true);
            String sql = "delete from goods where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            effect = preparedStatement.executeUpdate() == 1;
            return effect;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return effect;
    }
}
