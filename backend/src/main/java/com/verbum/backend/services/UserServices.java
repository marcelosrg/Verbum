package com.verbum.backend.services;

import com.verbum.backend.dto.RequestUserDto;
import com.verbum.backend.dto.ResponseUserDto;
import com.verbum.backend.mapper.UserMapper;
import com.verbum.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository,
                        UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public void createUser(RequestUserDto userDto){
        userRepository.save(userMapper.RequestUserDtoToUser(userDto));
    }

    public List<ResponseUserDto> getAllUsers(){
        var users = userRepository.findAll();
        return this.userMapper.UserToListUserDto(users).stream().collect(Collectors.toList());
    }
}
