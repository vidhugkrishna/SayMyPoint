package com.vidhu.sayMyPoint.Controller;

import com.vidhu.sayMyPoint.Model.Room;
import com.vidhu.sayMyPoint.Model.Story;
import com.vidhu.sayMyPoint.Service.RoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;



//    @GetMapping("/getUserStories/{roomId}")
//    public List<Story> getAllStory(String roomId){
//        return roomService.getAllStory(roomId);
//    }
//
//    @PostMapping("/addUserStoryInRoom")
//    public List<Story> addUserStory(@RequestBody Story story){
//        System.out.println("reached here");
//        return roomService.addUserStory(story);
//    }

    @PostMapping("/addMockRoom")
    public void createGroceryItems(){
        roomService.createGroceryItems();
    }

    @GetMapping("/getAll")
    public List<Room> getRooms(){
        return roomService.getAll();
    }

    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);

    }

    @DeleteMapping("/delete/{roomId}")
    public List<Room> deleteRoom(@PathVariable String roomId){
        System.out.println("this should be the id "+ roomId);
        roomService.deleteRoom(roomId);
        return getRooms();
    }





}
