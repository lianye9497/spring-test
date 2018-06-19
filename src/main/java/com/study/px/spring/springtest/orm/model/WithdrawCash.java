package com.study.px.spring.springtest.orm.model;

import java.math.BigDecimal;

public class WithdrawCash {
    private Integer id;

    private Integer userId;

    private BigDecimal withdrawPrice;

    private String createTime;

    private Integer mobile;

    private String cardholderName;

    private String identityCard;

    private String bankAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getWithdrawPrice() {
        return withdrawPrice;
    }

    public void setWithdrawPrice(BigDecimal withdrawPrice) {
        this.withdrawPrice = withdrawPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName == null ? null : cardholderName.trim();
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress == null ? null : bankAddress.trim();
    }
}