package com.jr.until;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Esuc {

    private String ename1;//开单企业
    private String ename2;//收单企业
    private String esuc1;//社会信用统一代码
    private String esuc2;

    public List<Esuc> queryEsuc(Esuc esuc) {
        Connection getconn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Esuc> esucs = new ArrayList<>();
        try {
            getconn = DBHelper.getconn();
            String sql = "select * from shitu";
            preparedStatement = getconn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                esucs.add(new Esuc(
                        resultSet.getString("ename1"),
                        resultSet.getString("ename2"),
                        resultSet.getString("esuc1"),
                        resultSet.getString("esuc2")
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(resultSet, preparedStatement, getconn);
        }
        return esucs;

    }


    public Esuc() {
    }

    @Override
    public String toString() {
        return "Esuc{" +
                "ename1='" + ename1 + '\'' +
                ", ename2='" + ename2 + '\'' +
                ", esuc1='" + esuc1 + '\'' +
                ", esuc2='" + esuc2 + '\'' +
                '}';
    }

    public Esuc(String ename1, String ename2,
                String esuc1, String esuc2) {
        this.ename1 = ename1;
        this.ename2 = ename2;
        this.esuc1 = esuc1;
        this.esuc2 = esuc2;
    }

    public String getEname1() {
        return ename1;
    }

    public void setEname1(String ename1) {
        this.ename1 = ename1;
    }

    public String getEname2() {
        return ename2;
    }

    public void setEname2(String ename2) {
        this.ename2 = ename2;
    }

    public String getEsuc1() {
        return esuc1;
    }

    public void setEsuc1(String esuc1) {
        this.esuc1 = esuc1;
    }

    public String getEsuc2() {
        return esuc2;
    }

    public void setEsuc2(String esuc2) {
        this.esuc2 = esuc2;
    }
}
