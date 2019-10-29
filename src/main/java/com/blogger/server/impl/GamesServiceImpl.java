package com.blogger.server.impl;

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
