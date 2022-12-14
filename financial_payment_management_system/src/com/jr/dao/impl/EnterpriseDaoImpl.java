package com.jr.dao.impl;

import com.jr.dao.IEnterpriseDao;
import com.jr.entry.Enterprise;
import com.jr.until.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseDaoImpl implements IEnterpriseDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Enterprise enterprise1;
    /**
     * 根据企业id查询企业信息
      */
    @Override
    public Enterprise queryByid(int id) {
        try {
            con=DBHelper.getconn();
            String sql="select * from enterprise where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,enterprise1.getId());
            rs=ps.executeQuery();
            while(rs.next()){
              enterprise1=new Enterprise();
              enterprise1.setId(rs.getInt(1));
              enterprise1.setName(rs.getString(2));
              enterprise1.setSocialUniformCcode(rs.getString(3));
              enterprise1.setEmail(rs.getString(4));
              enterprise1.setPhone(rs.getString(5));
              enterprise1.setAddress(rs.getString(6));
              enterprise1.setScale(rs.getString(7));
              enterprise1.setFax(rs.getString(8));

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
        return enterprise1;
    }
    /**
     *查询所有企业名称
     */
    @Override
    public List<Enterprise> queryAllEnterpriseNames() {
        List<Enterprise> list=new ArrayList<>();
        try {
            con=DBHelper.getconn();
            String sql="select name from enterprise";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                enterprise1=new Enterprise();
                enterprise1.setName(rs.getString(1));
                list.add(enterprise1);
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
        return list;

    }

    /**
     *增删改通用方法
     */
    public int upd(String sql, Object... objs) {

        int num = 0;
        try {
            con = DBHelper.getconn();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            num = ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }
        return num;
    }
}


