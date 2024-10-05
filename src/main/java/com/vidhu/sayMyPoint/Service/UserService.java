package com.vidhu.sayMyPoint.Service;

import com.vidhu.sayMyPoint.Model.User;
import com.vidhu.sayMyPoint.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
            return userRepository.save(user);


    }

    public User getUser(User user) {
        System.out.println("mail "+user.getEmail()+" username "+user.getUsername());
        if(user.getUsername().contains("@")){
            return userRepository.findByEmailAndPassword(user.getUsername(), user.getPassword());
        }else if(!user.getUsername().isEmpty()){
            return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        }else{
            return null;
        }

    }
}
