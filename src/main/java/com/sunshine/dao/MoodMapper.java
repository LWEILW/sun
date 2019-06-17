package com.sunshine.dao;

import com.sunshine.entity.Mood;
import com.sunshine.entity.MoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoodMapper {
    long countByExample(MoodExample example);

    int deleteByExample(MoodExample example);

    int insert(Mood record);

    int insertSelective(Mood record);

    List<Mood> selectByExample(MoodExample example);

    int updateByExampleSelective(@Param("record") Mood record, @Param("example") MoodExample example);

    int updateByExample(@Param("record") Mood record, @Param("example") MoodExample example);
}