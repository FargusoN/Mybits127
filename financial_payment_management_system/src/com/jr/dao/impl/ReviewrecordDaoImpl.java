package com.jr.dao.impl;

import com.jr.dao.IReviewrecordDao;
import com.jr.entry.Reviewrecord;
import com.jr.until.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewrecordDaoImpl implements IReviewrecordDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Reviewrecord reviewrecord1;
    /**
     * 插入审核记录
     * */
    @Override
    public int insertReviewrecord(Reviewrecord reviewrecord) {
    String sql="insert into review_record values(?,?,?,?,?,?)";
    int i=upd(sql);
    return i;

    }
    /**
     * 根据开单id查询审核记录信息
     * */
    @Override
    public Reviewrecord queryReviewrecord(int ticketId) {
        try {
            con=DBHelper.getconn();
            String sql="select r.*,t.id from review_record r,ticket_open t where r.ticket_open_id=t.id";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                reviewrecord1=new Reviewrecord();
                reviewrecord1.setId(rs.getInt(1));
                reviewrecord1.setTicketOpenId(rs.getInt(2));
                reviewrecord1.setCreatorId(rs.getInt(3));
                reviewrecord1.setCreateTime(rs.getDate(4));
                reviewrecord1.setReviewStatus(rs.getString(5));
                reviewrecord1.setRemark(rs.getString(6));
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
        return reviewrecord1;
    }

    /**
     *增删改的通用方法
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

