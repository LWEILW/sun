package com.sunshine.dao;

import com.sunshine.entity.Mood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MoodMapperEx {

    List<Mood> moodList();
}
