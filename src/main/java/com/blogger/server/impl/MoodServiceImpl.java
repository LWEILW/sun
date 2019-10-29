package com.blogger.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MoodService")
public class MoodServiceImpl implements MoodService {

    @Autowired
    private MoodMapperEx moodMapperEx;

    @Override
    public List<Mood> moodList(){
        return  moodMapperEx.moodList();
    }



}
