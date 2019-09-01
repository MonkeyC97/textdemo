package com.cashsystem.dao;

import com.cashsystem.common.AccountStatus;
import com.cashsystem.common.AccountType;
import com.cashsystem.entity.Account;
import org.apache.commons.codec.digest.DigestUtils;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends BaseDao{
    //操作数据库
    public Account login(String username,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//预处理SQL命令
        ResultSet resultSet = null;

        Account account = null;
        try{
            //拿到连接
            connection = this.getConnection(true);
            String sql = "select id,username,password,name,account_type,account_status " +
                    "from account where username = ?and password=?";


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,DigestUtils.md5Hex(password));

            resultSet = preparedStatement.executeQuery();
            //返回结果集到resultSet
            if(resultSet.next()){
                //解析resultSet，拿到对应的account
                account = extractAccount(resultSet);
                //extractAccount(resultSet)
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return account;
    }

    private  Account extractAccount(ResultSet resultSet){
        Account account = new Account();
        try {
            account.setId(resultSet.getInt("id"));
            account.setUsername(resultSet.getString("username"));
            account.setPassword(resultSet.getString("password"));
            account.setName(resultSet.getString("name"));
            account.setAccountType(AccountType.valueof(resultSet.getInt("account_type")));
            account.setAccountStatus(AccountStatus.valueof(resultSet.getInt("account_status")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    //注册
    public boolean register(Account account){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//预处理SQL命令
        ResultSet resultSet = null;
        boolean effect = false;

        try{
            connection = this.getConnection(true);
            String sql = "insert into account(username,password,name," +
                    "account_type,account_status) values(?,?,?,?,?)";
            //Statement.RETURN_GENERATED_KEYS在预编译的时候就获取自增的id的值
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,DigestUtils.md5Hex(account.getPassword()));
            preparedStatement.setString(3,account.getName());
            preparedStatement.setInt(4,account.getAccountType().getFlag());
            preparedStatement.setInt(5,account.getAccountStatus().getFlag());

           effect =  (preparedStatement.executeUpdate() == 1);
           //获取自增的主键
            resultSet = preparedStatement.getGeneratedKeys();

           if(resultSet.next()){
               Integer id = resultSet.getInt(1);
               account.setId(id);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return effect;
    }
    //浏览账户
    public List<Account> queryAllAccount(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Account> list = new ArrayList<>();
        try{
            connection = this.getConnection(true);
            String sql = "select * from account";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Account account = this.extractAccount(resultSet);
                list.add(account);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return null;
    }

    //重置密码
    public boolean updatePassword(String password,Account account){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = this.getConnection(true);
            String sql = "update account set password=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,DigestUtils.md5Hex(password));
            preparedStatement.setInt(2,account.getId());
            return preparedStatement.executeUpdate()==1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return false;
    }

    //输入原密码
    public Account getAccountByPassword(String password){
        Account account = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = this.getConnection(true);
            String sql = "select * from account where password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,DigestUtils.md5Hex(password));
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                account = this.extractAccount(resultSet);
            }
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return null;
    }
    //根据id得到Account
    public Account getAccountById(int id){
        Account account = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = this.getConnection(true);
            String sql = "select * from account where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                account = this.extractAccount(resultSet);
                return account;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return null;
    }

    public boolean updateAccount(Account account){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = this.getConnection(true);
            String sql ="update account set account_type=?,account_status=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,account.getAccountType().getFlag());
            preparedStatement.setInt(2,account.getAccountStatus().getFlag());
            preparedStatement.setInt(3,account.getId());
            return preparedStatement.executeUpdate()==1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return false;
    }
}
