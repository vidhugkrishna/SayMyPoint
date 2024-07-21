package com.vidhu.sayMyPoint.Service;

import com.vidhu.sayMyPoint.Model.Room;
import com.vidhu.sayMyPoint.Model.Story;
import com.vidhu.sayMyPoint.Repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepo;

    public Room openNewRoom(Room room) {
        return roomRepo.save(room);
    }

    public Optional<Room> getAllRoom(String roomId) {
        return roomRepo.findById(roomId);
    }

    public List<Room> getAll(){
        return roomRepo.findAll();
    }

    public List<Story> addUserStory(Story story) {
        return null;
    }
    public void createGroceryItems() {
            System.out.println("Data creation started...");
          //  roomRepo.save(new Room("ets43235", "Ares", null));
          //  roomRepo.save(new Room("ets11235", "Delta", null));
          //  roomRepo.save(new Room("ets11233", "alpha", null));
            System.out.println("Data creation complete...");
        }

    public void deleteRoom(String roomId) {
        roomRepo.deleteById(roomId);
    }

    public Room addRoom(Room room) {
        return roomRepo.save(room);
    }
}
