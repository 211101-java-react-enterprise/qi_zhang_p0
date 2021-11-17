package com.revature.Bank_App.DAO;

import com.revature.Bank_App.ObjectModel.Account;
import com.revature.Bank_App.util.ConnectionFactory;
import com.revature.Bank_App.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao implements CrudDAO{



    public Account save(Account account) {
        Account newAccount;
        try(Connection conn= ConnectionFactory.getInstance().getConnection()){
            //prepare SQL statement
            String sql_statement=
                    "insert into accounts (account_id, type_id, username) values (?, ?, ?)";
            PreparedStatement pre_statement=conn.prepareStatement(sql_statement);
            pre_statement.setString(1,account.getAccountNumber());
            pre_statement.setInt(2,account.getType());
            pre_statement.setString(3,account.getUsername());
            //Execute statement and save
            int rowsInserted = pre_statement.executeUpdate();
            if(rowsInserted!=0){
                newAccount=account;
                return newAccount;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Account account) {
        try(Connection conn= ConnectionFactory.getInstance().getConnection()){
            //prepare SQL statement
            String sql_statement= "update accounts set balance= ? where account_id= ?";
            PreparedStatement pre_statement=conn.prepareStatement(sql_statement);
            pre_statement.setDouble(1,account.getAccountBalance());
            pre_statement.setString(2,account.getAccountNumber());
            //Execute statement and save
            int rowsInserted = pre_statement.executeUpdate();
            if(rowsInserted!=0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Object save(Object newObj) {return null;}
    @Override
    public List findAll() {
        return null;
    }
    @Override
    public Object findById(String id) {
        return null;
    }
    @Override
    public boolean update(Object updatedObj) {
        return false;
    }
    @Override
    public boolean removeById(String id) {
        return false;
    }
}
