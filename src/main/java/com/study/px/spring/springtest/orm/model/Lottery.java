package com.study.px.spring.springtest.orm.model;

import java.math.BigDecimal;

public class Lottery {
    private Integer id;

    private String ticketNumber;

    private Integer lotteryTypeId;

    private BigDecimal parPrice;

    private String lotteryPhoto;

    private Boolean state;

    private Boolean settlementStatus;

    private BigDecimal commission;

    private Integer lotteryWindowId;

    private Integer createTime;

    private Integer updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber == null ? null : ticketNumber.trim();
    }

    public Integer getLotteryTypeId() {
        return lotteryTypeId;
    }

    public void setLotteryTypeId(Integer lotteryTypeId) {
        this.lotteryTypeId = lotteryTypeId;
    }

    public BigDecimal getParPrice() {
        return parPrice;
    }

    public void setParPrice(BigDecimal parPrice) {
        this.parPrice = parPrice;
    }

    public String getLotteryPhoto() {
        return lotteryPhoto;
    }

    public void setLotteryPhoto(String lotteryPhoto) {
        this.lotteryPhoto = lotteryPhoto == null ? null : lotteryPhoto.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(Boolean settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Integer getLotteryWindowId() {
        return lotteryWindowId;
    }

    public void setLotteryWindowId(Integer lotteryWindowId) {
        this.lotteryWindowId = lotteryWindowId;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }
}