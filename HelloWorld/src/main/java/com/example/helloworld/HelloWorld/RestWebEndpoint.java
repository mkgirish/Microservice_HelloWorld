package com.example.helloworld.HelloWorld;

import com.example.helloworld.HelloWorld.model.Message;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestWebEndpoint {

    @RequestMapping(value = "/hello/", method = RequestMethod.GET, produces = { "application/json" })
    public List<Message> helloMessage()
    {
        //Get data from service layer into entityList.

        List<Message> message = new ArrayList<Message>();
        message.add(new Message("Hello World"));

        return message;
    }
}
