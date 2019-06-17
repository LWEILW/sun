package com.sunshine.dao;

import com.sunshine.entity.Games;
import com.sunshine.entity.GamesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GamesMapper {
    long countByExample(GamesExample example);

    int deleteByExample(GamesExample example);

    int insert(Games record);

    int insertSelective(Games record);

    List<Games> selectByExample(GamesExample example);

    int updateByExampleSelective(@Param("record") Games record, @Param("example") GamesExample example);

    int updateByExample(@Param("record") Games record, @Param("example") GamesExample example);
}