package com.study.px.spring.springtest.orm.mapper;

import com.study.px.spring.springtest.orm.model.LotteryWindow;
import com.study.px.spring.springtest.orm.model.LotteryWindowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LotteryWindowMapper {
    int countByExample(LotteryWindowExample example);

    int deleteByExample(LotteryWindowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LotteryWindow record);

    int insertSelective(LotteryWindow record);

    List<LotteryWindow> selectByExample(LotteryWindowExample example);

    LotteryWindow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LotteryWindow record, @Param("example") LotteryWindowExample example);

    int updateByExample(@Param("record") LotteryWindow record, @Param("example") LotteryWindowExample example);

    int updateByPrimaryKeySelective(LotteryWindow record);

    int updateByPrimaryKey(LotteryWindow record);
}