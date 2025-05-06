package com.verbum.backend.services;

import com.verbum.backend.dto.RequestUserDto;
import com.verbum.backend.dto.ResponseUserDto;
import com.verbum.backend.mapper.UserMapper;
import com.verbum.backend.model.User;
import com.verbum.backend.repository.UserRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
        User newUser = new User();

        newUser.setName(userDto.name());
        newUser.setEmail(userDto.email());
        newUser.setPassword(userDto.password());
        newUser.setBiography(userDto.biography());
        newUser.setImage(userDto.image());

        userRepository.save(newUser);
    }

    public List<ResponseUserDto> getAllUsers(){
        var users = userRepository.findAll();
        return this.userMapper.UserToListUserDto(users);
    }
    public List<ResponseUserDto> getByName(String userName){
        var users = userRepository.findByNameContainingIgnoreCase(userName);
        return this.userMapper.UserToListUserDto(users);
    }

    public void updateUser(UUID userId, ResponseUserDto userDto){
       Optional<User> userOptional = userRepository.findById(userId);

       if(userOptional.isEmpty() && userId != userDto.id()) throw new IllegalArgumentException("Usuario não encontrado");


        userRepository.save(userMapper.UpdateUser(userDto));
    }
}
