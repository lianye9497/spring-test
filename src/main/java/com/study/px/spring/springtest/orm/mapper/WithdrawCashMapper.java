package com.study.px.spring.springtest.orm.mapper;

import com.study.px.spring.springtest.orm.model.WithdrawCash;
import com.study.px.spring.springtest.orm.model.WithdrawCashExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithdrawCashMapper {
    int countByExample(WithdrawCashExample example);

    int deleteByExample(WithdrawCashExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WithdrawCash record);

    int insertSelective(WithdrawCash record);

    List<WithdrawCash> selectByExample(WithdrawCashExample example);

    WithdrawCash selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WithdrawCash record, @Param("example") WithdrawCashExample example);

    int updateByExample(@Param("record") WithdrawCash record, @Param("example") WithdrawCashExample example);

    int updateByPrimaryKeySelective(WithdrawCash record);

    int updateByPrimaryKey(WithdrawCash record);
}