package com.vidhu.sayMyPoint.Repo;

import com.vidhu.sayMyPoint.Model.Room;
import com.vidhu.sayMyPoint.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByEmailAndPassword(String email, String password);
}
