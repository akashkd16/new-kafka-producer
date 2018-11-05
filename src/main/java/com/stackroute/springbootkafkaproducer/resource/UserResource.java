package com.stackroute.springbootkafkaproducer.resource;

import com.stackroute.springbootkafkaproducer.model.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private  static final String TOPIC ="test2";


    @PostMapping("user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        kafkaTemplate.send(TOPIC,user);
        responseEntity=new ResponseEntity<String>("Successfully Added", HttpStatus.CREATED);
        return responseEntity;
    }

//    @GetMapping("/publish/{name}")
//    public String post(@PathVariable("name") final String name) {
//
//        kafkaTemplate.send(TOPIC,name);
//        return name +" Published Successfully";
//
//    }

}
