package com.study.px.spring.springtest.trainTicket;

import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-01-31 14:25
 **/
@Data
public class TrainTicketVO {
    private String trainNo;
    private String startTime;
    private String endTime;
    private String consumeTime;
    private String highGradeSoftBerth;//高级软卧
    private String firstSoftSleeper; //一等软卧
    private String twoHardSleeper;//二等硬卧
    private String softSeat;//软座
    private String hardSeat;//硬座
    private String noSeat;//无座
    private String businessSeats; //商务座 32
    private String firstSeat; //一等座 31
    private String twoSeat;//二等座 30 17
    private String originatingStation;
    private String finalStation;
    private String startStation;
    private String endStation;
}
