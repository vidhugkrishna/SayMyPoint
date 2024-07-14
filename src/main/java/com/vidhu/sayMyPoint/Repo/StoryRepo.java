package com.vidhu.sayMyPoint.Repo;

import com.vidhu.sayMyPoint.Model.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class StoryRepo {

    @Autowired
    private Story story;

    private List<Story> storyList = new ArrayList<Story>();

    public boolean addStoryToDB(Story story) {
        System.out.println(story.toString()+"to be added");
        storyList.add(story);
        return storyList.contains(story);

    }
}
