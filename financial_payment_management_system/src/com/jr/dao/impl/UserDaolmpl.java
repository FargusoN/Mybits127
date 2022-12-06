package com.jr.dao.impl;

import com.jr.dao.IUserDao;
import com.jr.entry.User;
import com.jr.until.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaolmpl implements IUserDao {
    /**
     * 通过用户账号和用户密码查询指定用户，登入功能
     */
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public User queryByAccountAndPassword() {
        User user=new User();

        try {
            con= DBHelper.getconn();
            String sql="select * from user where account=? and password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getAccount());
            ps.setString(2,user.getPassword());
           rs=ps.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEnterPriseId(rs.getString(3));
                user.setPhone(rs.getString(4));
                user.setAccount(rs.getString(5));
                user.setPassword(rs.getString(6));
                user.setIdcardName(rs.getString(7));
                user.setIdcardNo(rs.getString(8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return user;
    }
}
