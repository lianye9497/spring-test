package com.study.px.spring.springtest.orm.mapper;

import com.study.px.spring.springtest.orm.model.BalanceAssetLog;
import com.study.px.spring.springtest.orm.model.BalanceAssetLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BalanceAssetLogMapper {
    int countByExample(BalanceAssetLogExample example);

    int deleteByExample(BalanceAssetLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BalanceAssetLog record);

    int insertSelective(BalanceAssetLog record);

    List<BalanceAssetLog> selectByExample(BalanceAssetLogExample example);

    BalanceAssetLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BalanceAssetLog record, @Param("example") BalanceAssetLogExample example);

    int updateByExample(@Param("record") BalanceAssetLog record, @Param("example") BalanceAssetLogExample example);

    int updateByPrimaryKeySelective(BalanceAssetLog record);

    int updateByPrimaryKey(BalanceAssetLog record);
}