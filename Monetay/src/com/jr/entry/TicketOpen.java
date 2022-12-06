package com.jr.entry;

import java.util.Date;

public class TicketOpen {
    private int id;
    private String no;
    private String enterPriseId;
    private String acquirerEnterPriseId;
    private double amount;
    private int institutyId;
    private Date createTime;
    private Date expiryTime;
    private String paymentInterestType;
    private String status;
    private String uplinkAddress;
    private String ticket_remark;

    public TicketOpen() {
    }

    public TicketOpen(int id, String no, String enterPriseId,
                      String acquirerEnterPriseId, double amount,
                      int institutyId, Date createTime, Date expiryTime,
                      String paymentInterestType, String status,
                      String uplinkAddress, String ticket_remark) {
        this.id = id;
        this.no = no;
        this.enterPriseId = enterPriseId;
        this.acquirerEnterPriseId = acquirerEnterPriseId;
        this.amount = amount;
        this.institutyId = institutyId;
        this.createTime = createTime;
        this.expiryTime = expiryTime;
        this.paymentInterestType = paymentInterestType;
        this.status = status;
        this.uplinkAddress = uplinkAddress;
        this.ticket_remark = ticket_remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEnterPriseId() {
        return enterPriseId;
    }

    public void setEnterPriseId(String enterPriseId) {
        this.enterPriseId = enterPriseId;
    }

    public String getAcquirerEnterPriseId() {
        return acquirerEnterPriseId;
    }

    public void setAcquirerEnterPriseId(String acquirerEnterPriseId) {
        this.acquirerEnterPriseId = acquirerEnterPriseId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getInstitutyId() {
        return institutyId;
    }

    public void setInstitutyId(int institutyId) {
        this.institutyId = institutyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getPaymentInterestType() {
        return paymentInterestType;
    }

    public void setPaymentInterestType(String paymentInterestType) {
        this.paymentInterestType = paymentInterestType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUplinkAddress() {
        return uplinkAddress;
    }

    public void setUplinkAddress(String uplinkAddress) {
        this.uplinkAddress = uplinkAddress;
    }

    public String getTicket_remark() {
        return ticket_remark;
    }

    public void setTicket_remark(String ticket_remark) {
        this.ticket_remark = ticket_remark;
    }

    @Override
    public String toString() {
        return "TicketOpen{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", enterPriseId='" + enterPriseId + '\'' +
                ", acquirerEnterPriseId='" + acquirerEnterPriseId + '\'' +
                ", amount=" + amount +
                ", institutyId=" + institutyId +
                ", createTime=" + createTime +
                ", expiryTime=" + expiryTime +
                ", paymentInterestType='" + paymentInterestType + '\'' +
                ", status='" + status + '\'' +
                ", uplinkAddress='" + uplinkAddress + '\'' +
                ", ticket_remark='" + ticket_remark + '\'' +
                '}';
    }
}
