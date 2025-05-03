package com.verbum.backend.controller;

import com.verbum.backend.dto.RequestUserDto;
import com.verbum.backend.model.User;
import com.verbum.backend.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserControler {

    private final UserServices userServices;
    public UserControler(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody RequestUserDto user) {
        this.userServices.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
