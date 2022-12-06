package com.jr.dao.impl;

import com.jr.dao.ITicketOpenDao;
import com.jr.entry.TicketOpen;
import com.jr.entry.User;
import com.jr.until.DBHelper;
import com.jr.until.PageHelper;
import com.jr.until.SqlHelper;
import com.jr.until.TicketView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询单个开单表的no编号 ,用模糊查询,使用ajax完成异步查询,(要写工具类)
 * 查询所有符合条件的开单列表信息
 */
public class TicketOpenDaoImpl implements ITicketOpenDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 按sql语句条件组合查询开单列表
     */
    @Override
    public List<TicketOpen> queryAllTicketopenByConditions(TicketOpen ticketOpen, SqlHelper sqlHelper) {
        List<TicketOpen> ticketOpens = new ArrayList<>();

        try {
            con = DBHelper.getconn();
            String sql = "select * from ticket_open where id is not null" + sqlHelper.sqlConcat();
            ps = con.prepareStatement(sql);
            rs = this.ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
                ticketOpens.add(new TicketOpen(rs.getInt("id"), rs.getString("no"), rs.getString("enterprise_id"), rs.getString("acquirer_enterprise_id"), rs.getDouble("amount"), rs.getInt("instituty_id"), simpleDateFormat.parse(rs.getString("create_time")), simpleDateFormat.parse(rs.getString("expiry_time")), rs.getString("payment_interest_type"), rs.getString("status"), rs.getString("uplink_address"), rs.getString("ticket_remark")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }

        return ticketOpens;
    }

    /**
     * 查找所有状态为开单中的开单列表
     */
    @Override
    public List<TicketOpen> QueryAllTicketopenByObTheBill(TicketOpen ticketOpen) {
        List<TicketOpen> ticketOpens = new ArrayList<>();

        try {
            con = DBHelper.getconn();
            String sql = "select * from ticket_open where  status='开单中' ";
            ps = con.prepareStatement(sql);
            rs = this.ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
                ticketOpens.add(new TicketOpen(rs.getInt("id"), rs.getString("no"), rs.getString("enterprise_id"), rs.getString("acquirer_enterprise_id"), rs.getDouble("amount"), rs.getInt("instituty_id"), simpleDateFormat.parse(rs.getString("create_time")), simpleDateFormat.parse(rs.getString("expiry_time")), rs.getString("payment_interest_type"), rs.getString("status"), rs.getString("uplink_address"), rs.getString("ticket_remark")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }
        return ticketOpens;
    }


    /**
     * 按凭证编号查找开单列表
     */
    public TicketOpen queryAllTicketopen(TicketOpen ticketOpen) {
        TicketOpen ticketOpens = new TicketOpen();

        try {
            con = DBHelper.getconn();
            String sql = "select * from ticket_open where no=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ticketOpen.getNo());
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                ticketOpens.setId(id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }


        return ticketOpens;
    }

    /**
     * 插入一条开单数据
     */
    @Override
    public int insertTicketopen(TicketOpen ticketOpen) {
        int i;
        try {
            con = DBHelper.getconn();
            String sql = "insert into ticket_open  values (null,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, ticketOpen.getNo());
            ps.setString(2, ticketOpen.getEnterPriseId());
            ps.setString(3, ticketOpen.getAcquirerEnterPriseId());
            ps.setDouble(4, ticketOpen.getAmount());
            ps.setInt(5, ticketOpen.getInstitutyId());
            ps.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(ticketOpen.getCreateTime()));
            ps.setString(7, new SimpleDateFormat("yyyy-MM-dd").format(ticketOpen.getExpiryTime()));
            ps.setString(8, ticketOpen.getPaymentInterestType());
            ps.setString(9, ticketOpen.getStatus());
            ps.setString(10, ticketOpen.getUplinkAddress());
            ps.setString(11, ticketOpen.getTicket_remark());

            i = ps.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }
        return i;
    }

    /**
     * 更新开单表状态
     */
    @Override
    public int updateTicketopen(TicketOpen ticketOpen) {
        int i;
        try {
            con = DBHelper.getconn();
            String sql = "update ticket_open set status=? where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ticketOpen.getStatus());
            ps.setInt(2, ticketOpen.getId());

            i = ps.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }
        return i;
    }

    @Override
    public TicketOpen selectTicketopenbyUserEnterId(User user) {
        TicketOpen t = null;
        try {
            con = DBHelper.getconn();
            String sql = "select * from ticket_open where id =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEnterPriseId());
            rs = ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (rs.next()) {
                t = new TicketOpen(rs.getInt("id"), rs.getString("no"), rs.getString("enterprise_id"), rs.getString("acquirer_enterprise_id"), rs.getDouble("amount"), rs.getInt("instituty_id"), simpleDateFormat.parse(rs.getString("create_time")), simpleDateFormat.parse(rs.getString("expiry_time")), rs.getString("payment_interest_type"), rs.getString("status"), rs.getString("uplink_address"), rs.getString("ticket_remark"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }

        return t;
    }

    /**
     * 查找开单表数据数量
     */
    @Override
    public int queryCountNum() {
        int num = 0;
        try {
            con = DBHelper.getconn();
            String sql = "select count(no) from ticketlist ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return num;
    }

    /**
     * 分页查找方法
     */
    @Override
    public List<TicketView> QueryByPage(PageHelper pageHelper, SqlHelper sqlHelper) {
        List<TicketView> list = new ArrayList<>();
        try {
            con = DBHelper.getconn();
            String sql = "select * from ticketlist where id!=0" + sqlHelper.sqlConcat();

            ps = con.prepareStatement(sql);
            ps.setInt(1, pageHelper.getStartNum());
            ps.setInt(2, pageHelper.getPageSize());
            System.out.println(sql);
            rs = ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            while (rs.next()) {
                try {
                    list.add(new TicketView(rs.getString("id"), rs.getString("no"), rs.getString("enterPriseId"), rs.getString("enp1name"), rs.getString("amount"), rs.getString("acquirerEnterPriseId"), rs.getString("enp2name"), rs.getString("insname"), simpleDateFormat.format(simpleDateFormat.parse(rs.getString("createTime"))), simpleDateFormat.format(simpleDateFormat.parse(rs.getString("expiry_time"))), rs.getString("uplink_address"), rs.getString("status")));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }

        return list;
    }
}


