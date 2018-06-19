package com.study.px.spring.springtest.orm.mapper;

import com.study.px.spring.springtest.orm.model.Channel;
import com.study.px.spring.springtest.orm.model.ChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelMapper {
    int countByExample(ChannelExample example);

    int deleteByExample(ChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    List<Channel> selectByExample(ChannelExample example);

    Channel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByExample(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}