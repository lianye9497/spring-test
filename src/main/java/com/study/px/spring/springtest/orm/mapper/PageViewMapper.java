package com.study.px.spring.springtest.orm.mapper;

import com.study.px.spring.springtest.orm.model.PageView;
import com.study.px.spring.springtest.orm.model.PageViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageViewMapper {
    int countByExample(PageViewExample example);

    int deleteByExample(PageViewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageView record);

    int insertSelective(PageView record);

    List<PageView> selectByExample(PageViewExample example);

    PageView selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageView record, @Param("example") PageViewExample example);

    int updateByExample(@Param("record") PageView record, @Param("example") PageViewExample example);

    int updateByPrimaryKeySelective(PageView record);

    int updateByPrimaryKey(PageView record);
}