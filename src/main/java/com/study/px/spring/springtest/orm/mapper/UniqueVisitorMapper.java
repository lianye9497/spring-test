package com.study.px.spring.springtest.orm.mapper;

import com.study.px.spring.springtest.orm.model.UniqueVisitor;
import com.study.px.spring.springtest.orm.model.UniqueVisitorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UniqueVisitorMapper {
    int countByExample(UniqueVisitorExample example);

    int deleteByExample(UniqueVisitorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UniqueVisitor record);

    int insertSelective(UniqueVisitor record);

    List<UniqueVisitor> selectByExample(UniqueVisitorExample example);

    UniqueVisitor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UniqueVisitor record, @Param("example") UniqueVisitorExample example);

    int updateByExample(@Param("record") UniqueVisitor record, @Param("example") UniqueVisitorExample example);

    int updateByPrimaryKeySelective(UniqueVisitor record);

    int updateByPrimaryKey(UniqueVisitor record);
}