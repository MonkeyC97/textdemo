package com.cashsystem.dao;

import com.cashsystem.common.AccountStatus;
import com.cashsystem.common.AccountType;
import com.cashsystem.entity.Account;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            preparedStatement.setString(2, DigestUtils.md5Hex(password));

            resultSet = preparedStatement.executeQuery();
            //返回结果集到resultSet
            if(resultSet.next()){
                //解析resultSet，拿到对应的account
                extractAccount(resultSet);
            }



        }catch (SQLException e){
            e.printStackTrace();
        }

        return account;
    }

    private static Account extractAccount(ResultSet resultSet){
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
}
