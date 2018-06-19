package com.study.px.spring.springtest.orm.mapper;

import com.study.px.spring.springtest.orm.model.OrderLottery;
import com.study.px.spring.springtest.orm.model.OrderLotteryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLotteryMapper {
    int countByExample(OrderLotteryExample example);

    int deleteByExample(OrderLotteryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderLottery record);

    int insertSelective(OrderLottery record);

    List<OrderLottery> selectByExample(OrderLotteryExample example);

    OrderLottery selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderLottery record, @Param("example") OrderLotteryExample example);

    int updateByExample(@Param("record") OrderLottery record, @Param("example") OrderLotteryExample example);

    int updateByPrimaryKeySelective(OrderLottery record);

    int updateByPrimaryKey(OrderLottery record);
}