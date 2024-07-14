package com.vidhu.sayMyPoint.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import java.util.List;

@Document("room")
public class Room {
    @Id
    String id;
    String roomName;
    List<Story> userStories;

    public Room(String id,String roomName, List<Story> userStories) {
        super();
        this.id=id;
        this.roomName = roomName;
        this.userStories = userStories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                '}';
    }

    public List<Story> getUserStories() {
        return userStories;
    }

    public void setUserStories(List<Story> userStories) {
        this.userStories = userStories;
    }
}
