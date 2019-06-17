package com.sunshine.server.impl;

import com.sunshine.dao.MoodMapperEx;
import com.sunshine.entity.Mood;
import com.sunshine.server.MoodService;
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
