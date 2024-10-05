package com.vidhu.sayMyPoint.Controller;

import com.google.gson.Gson;
import com.vidhu.sayMyPoint.Model.Response;
import com.vidhu.sayMyPoint.Model.User;
import com.vidhu.sayMyPoint.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        System.out.println("request came with ----"+user);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        User userSaved =  userService.createUser(user);
        if(Objects.isNull(userSaved)){

            return new Gson().toJson(new Response("404","","mail id already used"));
        }else{
            String jsonInString = new Gson().toJson(userSaved);
            return new Gson().toJson(new Response("200",jsonInString,"user saved sucess"));
        }
    }

    @PostMapping("/loginUser")
    public String getUser(@RequestBody User user){
        System.out.println("request came with "+user.getUsername());
        User userRes =  userService.getUser(user);

        if(Objects.isNull(userRes)){

            return new Gson().toJson(new Response("404","","user not found"));
        }else{
            String jsonInString = new Gson().toJson(userRes);
            return new Gson().toJson(new Response("200",jsonInString,"user login sucess"));
        }
    }
}
