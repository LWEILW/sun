package com.sunshine.server.impl;

import com.sunshine.dao.GamesMapperEx;
import com.sunshine.entity.Games;
import com.sunshine.server.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GamesService")
public class GamesServiceImpl implements GamesService {
    @Autowired
    private GamesMapperEx gamesMapperEx;
    @Override
    public List<Games> gamesList(){
        return gamesMapperEx.gamesList();
    }

}
