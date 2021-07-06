package com.example.dynatechhomework.controller;


import com.example.dynatechhomework.dto.UserDTO;
import com.example.dynatechhomework.dto.UserQuery;
import com.example.dynatechhomework.response.MessageResponse;
import com.example.dynatechhomework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserFromIDM(@PathVariable("userName") String userName){

        UserDTO userQuery = userService.getUserByName(userName);
        if(userQuery ==null){
            return new ResponseEntity<>(new MessageResponse("User with that username, does not exist"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userQuery, HttpStatus.OK);

    }
}
