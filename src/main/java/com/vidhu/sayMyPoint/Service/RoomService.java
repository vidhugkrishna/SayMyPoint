package com.vidhu.sayMyPoint.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.vidhu.sayMyPoint.Model.Message;
import com.vidhu.sayMyPoint.Model.Room;
import com.vidhu.sayMyPoint.Model.Story;
import com.vidhu.sayMyPoint.Model.Type;
import com.vidhu.sayMyPoint.Repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.vidhu.sayMyPoint.Model.Type.*;

@Service
public class RoomService {

    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RoomRepository roomRepo;
    public List<Room> getAll(){
        return roomRepo.findAll();
    }

    public void deleteRoom(String roomId) {
        roomRepo.deleteById(roomId);
    }
    public Message joinAndGetRoomId(String id,String sender){
        Optional<Room> joinedRoom =  roomRepo.findById(id);
        System.out.println("joinedRoom "+joinedRoom);
        joinedRoom.get().setUsers(addUserToRoom(joinedRoom.get().getUsers(),sender));
        Room responseRoom = roomRepo.save(joinedRoom.get());
        return createMessage(responseRoom,GROUPJOINED);
    }

    public Message addStory(String  messageString) throws JsonProcessingException {
        Story storyObj;
            storyObj  = objectMapper.readValue(messageString,Story.class);
        System.out.println("--------------"+"/Requestbody/"+storyObj.getRoomID()+"/message");
            Optional<Room> Room =  roomRepo.findById(storyObj.getRoomID());

            Room roomToModify = Room.get();
            List<Story> storyList = roomToModify.getUserStories();
            storyList.add(storyObj);
            roomToModify.setUserStories(storyList);
        Room responseRoom =  roomRepo.save(roomToModify);
        return createMessage(responseRoom,STORYADDED);


    }

    public Message addRoom(String room, String sender) {
        Room roomObj;
            try{
                roomObj  = objectMapper.readValue(room,Room.class);
                String[] users = roomObj.getUsers();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        Room responseRoom =  roomRepo.save(roomObj);
        return createMessage(responseRoom,GROUPCREATED);
    }

    public Message updateStory(Message messager) {
        Optional<Room> room =  roomRepo.findById(messager.getRoomId());
        Room roomToModifyCurrentStory = room.get();
        roomToModifyCurrentStory.setCurrentStory(messager.getMessage());
        Room responseRoom =  roomRepo.save(roomToModifyCurrentStory);
        Message responseMessage = new Message();
        responseMessage.setMessage(messager.getMessage());
        responseMessage.setResponseType(STORYUPDATED);
        responseMessage.setSender("system");
        responseMessage.setRoomId(messager.getRoomId());
        return responseMessage;
    }

    public Message createMessage(Room responseRoom, Type responseType){
        String jsonInString = new Gson().toJson(responseRoom);
        System.out.println("jsonInString "+jsonInString);
        Message responseMessage = new Message();
        responseMessage.setMessage(jsonInString);
        responseMessage.setResponseType(responseType);
        responseMessage.setSender("system");
        responseMessage.setRoomId(responseRoom.getId());
        return responseMessage;
    }

    public Message voteStory(Message message) throws JsonProcessingException {
        String roomId = message.getRoomId();
        String senderId = message.getSender();
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(message.getMessage(), Map.class);
        String userStory = (String) map.get("userstory");
        String vote = (String) map.get("vote");
        Optional<Room> room =  roomRepo.findById(roomId);
        Room roomToModifyVote = room.get();
        List<Story> currentStories =roomToModifyVote.getUserStories();

        for (Story currentStory:currentStories) {
            System.out.println("##currentStory.getStoryDetail() "+currentStory.getStoryDetail());
            System.out.println("##userStory "+userStory);
            System.out.println("##condition 1 "+currentStory.getStoryDetail().equalsIgnoreCase(userStory));
            if(currentStory.getStoryDetail().equalsIgnoreCase(userStory)){
                String[] votesData = currentStory.getVote();
                System.out.println("##votesData " + votesData);
                List<String> votesDataList = new ArrayList<>(Arrays.asList(votesData));
                System.out.println("##votesDataList " + votesDataList);

                if(isVoted(votesData,senderId)) {
                    for (String voteData : votesDataList) {
                        System.out.println("##voteData " + voteData);
                        if (voteData.contains(senderId)) {
                                System.out.println("######## ");
                                String currentVote = voteData.substring(voteData.indexOf("#vote") + 5, voteData.length());
                                votesDataList.set(votesDataList.indexOf(senderId+"#vote" + currentVote),senderId+"#vote" + vote);
                        }
                        System.out.println("voteData " + voteData);
                    }
                    System.out.println("voteDatas " + votesDataList.get(0));

                }else{
                    String voteInput = senderId+"#vote"+vote;
                    votesDataList.add(voteInput);

                }
                String[] arr = new String[votesDataList.size()];
                arr = (String[]) votesDataList.toArray(arr);
                System.out.println("arr " + arr);
                currentStory.setVote(arr);
            }

        }
        Room responseRoom =  roomRepo.save(roomToModifyVote);
        return createMessage(responseRoom,STORYVOTED);
    }

    public String[] addUserToRoom(String[] users, String user){
        List<String> myList = new ArrayList<>(Arrays.asList(users));
        if(!myList.contains(user)){
            myList.add(user);
        }
        return myList.toArray(new String[0]);

    }

    public boolean isVoted(String[] list,String senderId){
        for (String listItem : list) {
            if(listItem.contains(senderId)){
                return true;
            }
        }
        return false;
    }

    public Message getCurrentStory(Message message) {
        Optional<Room> room =  roomRepo.findById(message.getRoomId());
        Room roomToGetCurrentStory = room.get();
        String currentStory= roomToGetCurrentStory.getCurrentStory();
        Message responseMessage = new Message();
        responseMessage.setMessage(currentStory);
        responseMessage.setResponseType(STORYUPDATED);
        responseMessage.setSender(message.getSender());
        responseMessage.setRoomId(message.getRoomId());
        return responseMessage;
}
}
