package com.vidhu.sayMyPoint.Model;

import org.springframework.stereotype.Component;

@Component
public class Story {

    String storyDetail;
    int vote;
    String roomID;



    @Override
    public String toString() {
        return "Story{" +
                "storyDetail='" + storyDetail + '\'' +
                ", vote=" + vote +
                '}';
    }

    public String getStoryDetail() {
        return storyDetail;
    }

    public void setStoryDetail(String storyDetail) {
        this.storyDetail = storyDetail;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}
