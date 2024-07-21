package com.vidhu.sayMyPoint.Service;

import com.vidhu.sayMyPoint.Model.User;
import com.vidhu.sayMyPoint.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }
}
