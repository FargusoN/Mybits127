package com.jr.dao.impl;

import com.jr.dao.IInstitutyDao;
import com.jr.entry.Instituty;
import com.jr.until.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstitutyDaoImpl implements IInstitutyDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Instituty instituty1;
    /**
     *查询所有金融机构名称
     * */
    @Override
    public List<Instituty> queryAllNames() {
        List<Instituty> list=new ArrayList<>();
        try {
            con=DBHelper.getconn();
            String sql="select name from instituty";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                instituty1=new Instituty();
                instituty1.setName(rs.getString(1));
                list.add(instituty1);
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
