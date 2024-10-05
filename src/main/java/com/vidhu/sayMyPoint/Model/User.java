package com.vidhu.sayMyPoint.Model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Collection;

@Document
@NoArgsConstructor
public class User{

    String username;


    @Id
    String Id;
    String email;
    String token;

    String password;

    public User( String Id,String token, String username, String email, String password) {
        super();
        this.Id = Id;
        this.token = token;
        this.username = username;
        this.email = email;
        this.password = password;
    }



    public void setName(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }




    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
