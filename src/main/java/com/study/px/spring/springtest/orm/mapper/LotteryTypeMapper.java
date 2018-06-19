package com.study.px.spring.springtest.orm.mapper;

import com.study.px.spring.springtest.orm.model.LotteryType;
import com.study.px.spring.springtest.orm.model.LotteryTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LotteryTypeMapper {
    int countByExample(LotteryTypeExample example);

    int deleteByExample(LotteryTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LotteryType record);

    int insertSelective(LotteryType record);

    List<LotteryType> selectByExample(LotteryTypeExample example);

    LotteryType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LotteryType record, @Param("example") LotteryTypeExample example);

    int updateByExample(@Param("record") LotteryType record, @Param("example") LotteryTypeExample example);

    int updateByPrimaryKeySelective(LotteryType record);

    int updateByPrimaryKey(LotteryType record);
}