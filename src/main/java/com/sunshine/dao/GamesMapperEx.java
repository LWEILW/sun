package com.sunshine.dao;

import com.sunshine.entity.Games;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GamesMapperEx {

    List<Games> gamesList();
}
