package com.verbum.backend.controller;

import com.verbum.backend.dto.RequestUserDto;
import com.verbum.backend.dto.ResponseUserDto;

import com.verbum.backend.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserControler {

    private final UserServices userServices;
    public UserControler(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResponseUserDto>> getAll(){
        var users = userServices.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody RequestUserDto user) {
        this.userServices.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
