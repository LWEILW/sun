package com.sunshine.controller;

import com.sunshine.entity.Mood;
import com.sunshine.server.MoodService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "[APP-测试接口]-FrontExaminationReportController")
@RestController
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @GetMapping("/moodList")
    public List<Mood> moodList() {
        List<Mood> moodList = moodService.moodList();
        System.out.println("moodList");
        return moodList;
    }
}
