package com.study.px.spring.springtest.orm.model;

public class OrderLottery {
    private Integer id;

    private Integer orderId;

    private Integer lotteryId;

    private Integer winningStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(Integer lotteryId) {
        this.lotteryId = lotteryId;
    }

    public Integer getWinningStatus() {
        return winningStatus;
    }

    public void setWinningStatus(Integer winningStatus) {
        this.winningStatus = winningStatus;
    }
}