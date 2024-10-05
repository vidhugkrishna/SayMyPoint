package com.vidhu.sayMyPoint.Model;

import org.springframework.stereotype.Component;

@Component
public class Story {

    String storyDetail;
    String[] vote;
    String roomID;

    public Story(String storyDetail, String[] vote, String roomID) {
        this.storyDetail = storyDetail;
        this.vote = vote;
        this.roomID = roomID;
    }

    public Story() {
    }


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

    public String[] getVote() {
        return vote;
    }

    public void setVote(String[] vote) {
        this.vote = vote;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}
