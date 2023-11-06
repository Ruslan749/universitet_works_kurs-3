package com.example.exe8_springsecurity.service;

import com.example.exe8_springsecurity.dto.UserDto;
import com.example.exe8_springsecurity.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
