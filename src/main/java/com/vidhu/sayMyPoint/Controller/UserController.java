package com.vidhu.sayMyPoint.Controller;

import com.vidhu.sayMyPoint.Model.User;
import com.vidhu.sayMyPoint.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        System.out.println("request came with "+user);
        return userService.createUser(user);
    }
}
