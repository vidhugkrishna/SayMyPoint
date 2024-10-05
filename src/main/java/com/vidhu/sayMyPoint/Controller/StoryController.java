package com.vidhu.sayMyPoint.Controller;

import com.vidhu.sayMyPoint.Model.Story;
import com.vidhu.sayMyPoint.Service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoryController {



//    @PostMapping("addStory")
//    public String addStory(@RequestBody Story story){
//        System.out.println(story.toString()+ "did we received the object");
//        return storyService.validateAndAddStory(story);
//
//    }
}
