package com.verbum.backend.services;

import com.verbum.backend.dto.RequestUserDto;
import com.verbum.backend.dto.ResponseUserDto;
import com.verbum.backend.dto.UpdateUserDto;
import com.verbum.backend.mapper.UserMapper;
import com.verbum.backend.model.User;
import com.verbum.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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


    public List<ResponseUserDto> getAllUsers(){
        var users = userRepository.findAll();
        return this.userMapper.UserToListUserDto(users);
    }

    public List<ResponseUserDto> getByName(String userName){
        var users = userRepository.findByNameContainingIgnoreCase(userName);
        return this.userMapper.UserToListUserDto(users);
    }

    public ResponseUserDto createUser(RequestUserDto userDto){
        User user = userMapper.RequestUserDtoToUser(userDto);
        userRepository.save(user);

        return userMapper.UserToResponseUserDto(user);
    }

    @Transactional
    public ResponseUserDto updateUser(UUID id, UpdateUserDto updateDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        userMapper.updateUserFromDto(updateDto, user);

        User updatedUser = userRepository.save(user);

        return userMapper.UserToResponseUserDto(updatedUser);
    }
}
