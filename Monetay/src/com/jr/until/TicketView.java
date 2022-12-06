package com.jr.until;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketView {
    private String id;
    private String no;
    private String enterPriseId;
    private String enp1name;
    private String amount;
    private String acquirerEnterPriseId;
    private String enp2name;
    private String insname;
    private String createTime;
    private String expiryTime;
    private String uplink_address;
    private String status;

    public TicketView(String id, String no, String enterPriseId,
                      String enp1name, String amount,
                      String acquirerEnterPriseId, String enp2name,
                      String insname, String createTime, String expiryTime,
                      String uplink_address, String status) {
        this.id = id;
        this.no = no;
        this.enterPriseId = enterPriseId;
        this.enp1name = enp1name;
        this.amount = amount;
        this.acquirerEnterPriseId = acquirerEnterPriseId;
        this.enp2name = enp2name;
        this.insname = insname;
        this.createTime = createTime;
        this.expiryTime = expiryTime;
        this.uplink_address = uplink_address;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TicketView{" +
                "id='" + id + '\'' +
                ", no='" + no + '\'' +
                ", enterPriseId='" + enterPriseId + '\'' +
                ", enp1name='" + enp1name + '\'' +
                ", amount='" + amount + '\'' +
                ", acquirerEnterPriseId='" + acquirerEnterPriseId + '\'' +
                ", enp2name='" + enp2name + '\'' +
                ", insname='" + insname + '\'' +
                ", createTime='" + createTime + '\'' +
                ", expiryTime='" + expiryTime + '\'' +
                ", uplink_address='" + uplink_address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public TicketView() {
    }

    public List<TicketView> selectAll() {
        List<TicketView> ticketViews = new ArrayList<>();

        Connection getconn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            getconn = DBHelper.getconn();
            String sql = "select * from ticketlist";
            preparedStatement = getconn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TicketView ticketView1 = new TicketView(
                        resultSet.getString("id"),
                        resultSet.getString("no"),
                        resultSet.getString("enterPriseId"),
                        resultSet.getString("enp1name"),
                        resultSet.getString("amount"),
                        resultSet.getString("acquirerEnterPriseId"),
                        resultSet.getString("enp2name"),
                        resultSet.getString("insname"),
                        resultSet.getString("createTime"),
                        resultSet.getString("expiry_Time"),
                        resultSet.getString("uplink_address"),
                        resultSet.getString("status"));
                ticketViews.add(ticketView1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(resultSet, preparedStatement, getconn);
        }
        return ticketViews;
    }

    public List<TicketView> selectAllByConnditions(SqlHelper sqlHelper) {
        List<TicketView> ticketViews = new ArrayList<>();

        Connection getconn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            getconn = DBHelper.getconn();
            String sql = "select * from ticketlist where  no!=0 " + sqlHelper.sqlConcat();

            System.out.println(sql);
            preparedStatement = getconn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TicketView ticketView1 = new TicketView(
                        resultSet.getString("id"),
                        resultSet.getString("no"),
                        resultSet.getString("enterPriseId"),
                        resultSet.getString("enp1name"),
                        resultSet.getString("amount"),
                        resultSet.getString("acquirerEnterPriseId"),
                        resultSet.getString("enp2name"),
                        resultSet.getString("insname"),
                        resultSet.getString("createTime"),
                        resultSet.getString("expiry_time"),
                        resultSet.getString("uplink_address"),
                        resultSet.getString("status"));
                ticketViews.add(ticketView1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(resultSet, preparedStatement, getconn);
        }
        return ticketViews;
    }
}
