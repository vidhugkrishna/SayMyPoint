package com.vidhu.sayMyPoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vidhu.sayMyPoint.Model.Message;
import com.vidhu.sayMyPoint.Model.Room;
import com.vidhu.sayMyPoint.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller

public class WSRoomController {



    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private RoomService roomService;

    public WSRoomController() {
    }

    @MessageMapping("/creategroup")
    public Message createGroup(@Payload Message message) throws Exception {
        System.out.println("sender info "+message.getSender());
        Message resmessage =  roomService.addRoom(message.getMessage(),message.getSender());
        simpMessagingTemplate.convertAndSendToUser(message.getSender().substring(0,message.getSender().indexOf("-")),"/group/notification",resmessage);
        //simpMessagingTemplate.convertAndSendToUser(message.getRoomId(),"/message",resmessage);
        return  resmessage;
    }

    @MessageMapping("/joingroup")
    public Message joinGroup(@Payload Message message) throws Exception {
        System.out.println("Check destination "+message.getSender().substring(0,message.getSender().indexOf("-")));
        Message resMessage = roomService.joinAndGetRoomId(message.getMessage(),message.getSender());
        simpMessagingTemplate.convertAndSendToUser(message.getSender().substring(0,message.getSender().indexOf("-")),"/group/notification",resMessage);
        System.out.println("00000000000000 "+"/room/"+resMessage.getRoomId()+"/message");
        simpMessagingTemplate.convertAndSend("/room/"+resMessage.getRoomId()+"/message",resMessage);
        return resMessage;
    }



    @MessageMapping("/groupmessage")
    public Message groupGreeting(@Payload Message message) throws Exception {
        System.out.println("hi reached grtr");
        simpMessagingTemplate.convertAndSendToUser(message.getRoomId(),"/room",message);
        return message;
    }

    @MessageMapping("/addstory")
    public Message addStory(@Payload Message message) throws JsonProcessingException {
        System.out.println("--------------"+"/Requestbody/"+message.getRoomId()+"/message");
        Message resmessage =  roomService.addStory(message.getMessage());
        System.out.println("--------------"+"/room/"+resmessage.getRoomId()+"/message");
        simpMessagingTemplate.convertAndSend("/room/"+resmessage.getRoomId()+"/message",resmessage);
        return resmessage;
    }

    @MessageMapping("/votestory")
    public Message voteStory(@Payload Message message) throws JsonProcessingException {
        System.out.println("--------------"+"/Requestbody/"+message.getRoomId()+"/message");
        Message resmessage =  roomService.voteStory(message);
        System.out.println("--------------"+"/room/"+resmessage.getRoomId()+"/message");
        simpMessagingTemplate.convertAndSend("/room/"+resmessage.getRoomId()+"/message",resmessage);
        return resmessage;
    }

    @MessageMapping("/updatestory")
    public Message updateStory(@Payload Message message) throws JsonProcessingException {
        System.out.println("--------------"+"/Requestbody/"+message.getRoomId()+"/message");
        Message resmessage =  roomService.updateStory(message);
        System.out.println("--------------"+"/room/"+resmessage.getRoomId()+"/message");
        simpMessagingTemplate.convertAndSend("/room/"+resmessage.getRoomId()+"/message",resmessage);
        return resmessage;
    }
    @MessageMapping("/getCurrentStory")
    public Message getCurrentStory(@Payload Message message) throws JsonProcessingException {
        System.out.println("--------------"+"/Requestbody/"+message.getRoomId()+"/message");
        Message resmessage =  roomService.getCurrentStory(message);
        System.out.println("--------------"+"/room/"+resmessage.getRoomId()+"/message");
        simpMessagingTemplate.convertAndSend("/room/"+resmessage.getRoomId()+"/message",resmessage);
        return resmessage;
    }
}