package com.vidhu.sayMyPoint.Service;

import com.vidhu.sayMyPoint.Model.Story;
import com.vidhu.sayMyPoint.Repo.StoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService {

    @Autowired
    private StoryRepo storyRepo;

    public String validateAndAddStory(Story story) {
        return storyRepo.addStoryToDB(story) ? "Added to db" : "Failed to add";
    }
}
