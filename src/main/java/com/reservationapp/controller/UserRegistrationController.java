package com.reservationapp.controller;

import com.reservationapp.entity.UserRegistration;
import com.reservationapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("profilePicture")MultipartFile profilePicture
            ){
        try {
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setName(name);
        userRegistration.setEmail(email);
        userRegistration.setPassword(password);

        userRegistration.setProfilePicture(profilePicture.getBytes());

        userService.createUser(userRegistration);

        } catch (Exception e) {
         e.printStackTrace();
        }

        return "Done" ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRegistration> getUserById(@PathVariable long id){
        UserRegistration user = userService.getUserById(id);
        return  new ResponseEntity<>(user, HttpStatus.OK);

    }


}
