package com.verbum.backend.controller;

import com.verbum.backend.dto.user.RequestUserDto;
import com.verbum.backend.dto.user.ResponseUserDto;

import com.verbum.backend.dto.user.UpdateUserDto;
import com.verbum.backend.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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
    @GetMapping("/{name}")
    public ResponseEntity<List<ResponseUserDto>> getByName(@PathVariable String name){
        var users = userServices.getByName(name);
        return ResponseEntity.ok(users);
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseUserDto> createUser( @RequestBody RequestUserDto userDto) {
        ResponseUserDto createdUser = userServices.createUser(userDto);
        return ResponseEntity
                .created(URI.create("/users/" + createdUser.id()))
                .body(createdUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseUserDto> updateUser(@PathVariable UUID id, @RequestBody UpdateUserDto user) {
        ResponseUserDto updatedUser = userServices.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }


}
