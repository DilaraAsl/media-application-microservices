package com.tsg.service;

import com.tsg.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<UserDto> findAll();
    public UserDto save(UserDto userDto);

    public UserDto findUser(int id);
}
