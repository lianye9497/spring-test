package com.study.px.spring.springtest.trainTicket;

import com.study.px.spring.springtest.BaseResult;
import com.study.px.spring.springtest.IgnoreToken;
import com.study.px.spring.springtest.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-01-31 14:12
 **/
@RestController
@RequestMapping("trainTicket")
public class TrainTicketController extends BaseController {

    @Autowired
    TrainTicketService trainTicketService;

    @IgnoreToken
    @PostMapping("query")
    public BaseResult query(@RequestBody TrainTicketQueryVO vo){
        List<TrainTicketVO> query = trainTicketService.query(vo);
        return successWithData(query);
    }

    @IgnoreToken
    @GetMapping("stations")
    public BaseResult stations(){
        List<StationNameVO> query = trainTicketService.stations();
        return successWithData(query);
    }


}
