package com.study.px.spring.springtest.orm.mapper;

import com.study.px.spring.springtest.orm.model.OrderPayResult;
import com.study.px.spring.springtest.orm.model.OrderPayResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderPayResultMapper {
    int countByExample(OrderPayResultExample example);

    int deleteByExample(OrderPayResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderPayResult record);

    int insertSelective(OrderPayResult record);

    List<OrderPayResult> selectByExample(OrderPayResultExample example);

    OrderPayResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderPayResult record, @Param("example") OrderPayResultExample example);

    int updateByExample(@Param("record") OrderPayResult record, @Param("example") OrderPayResultExample example);

    int updateByPrimaryKeySelective(OrderPayResult record);

    int updateByPrimaryKey(OrderPayResult record);
}