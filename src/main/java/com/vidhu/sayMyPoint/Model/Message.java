package com.vidhu.sayMyPoint.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String sender;
    private String roomId;

    public Type getResponseType() {
        return responseType;
    }

    private Type responseType;

    public String getMessage() {
        return message;
    }

    private String message;



    public String getRoomId() {
        return this.roomId;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setResponseType(Type responseType) {
        this.responseType = responseType;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
