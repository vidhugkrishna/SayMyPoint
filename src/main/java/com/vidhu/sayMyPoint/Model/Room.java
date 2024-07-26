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
    String roomType;
    String[] cards;
    boolean accessToAddStory;
    boolean votingStatus;
    boolean voteRevealedAtEnd;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }

    public boolean isAccessToAddStory() {
        return accessToAddStory;
    }

    public void setAccessToAddStory(boolean accessToAddStory) {
        this.accessToAddStory = accessToAddStory;
    }

    public boolean getVotingStatus() {
        return votingStatus;
    }

    public void setVotingStatus(boolean value) {
        this.votingStatus = value;
    }

    public boolean isVoteRevealedAtEnd() {
        return voteRevealedAtEnd;
    }

    public void setVoteRevealedAtEnd(boolean voteRevealedAtEnd) {
        this.voteRevealedAtEnd = voteRevealedAtEnd;
    }







    public Room(String id, String roomName, List<Story> userStories, String roomType, String[] cards, boolean accessToAddStory, boolean skippingConfirmation, boolean voteRevealedAtEnd) {
        super();
        this.id = id;
        this.roomName = roomName;
        this.userStories = userStories;
        this.roomType = roomType;
        this.cards = cards;
        this.accessToAddStory = accessToAddStory;
        this.votingStatus = skippingConfirmation;
        this.voteRevealedAtEnd = voteRevealedAtEnd;
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
