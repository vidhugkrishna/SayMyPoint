package com.vidhu.sayMyPoint.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Response {

    private String body;
    private String status;
    private String message;

    public Response(String status, String body, String message) {
        this.status =status;
        this.body = body;
        this.message = message;
    }
}
