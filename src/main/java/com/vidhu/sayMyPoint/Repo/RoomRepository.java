package com.vidhu.sayMyPoint.Repo;

import java.util.*;
import com.vidhu.sayMyPoint.Model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface RoomRepository extends MongoRepository<Room, String> {


}
