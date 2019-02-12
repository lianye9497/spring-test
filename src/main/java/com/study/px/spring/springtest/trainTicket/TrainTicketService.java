package com.study.px.spring.springtest.trainTicket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-01-31 14:24
 **/
@Slf4j
@Service
public class TrainTicketService {

    public List<TrainTicketVO> query(TrainTicketQueryVO vo){
       return TrainTicket.query(vo);
    }

    public List<StationNameVO> stations() {
        return TrainTicket.getStationNames();
    }
}
