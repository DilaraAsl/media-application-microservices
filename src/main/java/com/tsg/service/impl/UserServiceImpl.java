package com.tsg.service.impl;

import com.tsg.dto.UserDto;
import com.tsg.entity.User;
import com.tsg.exceptions.UserNotFoundException;
import com.tsg.repository.UserRepository;
import com.tsg.service.UserService;
import com.tsg.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user->mapperUtil.convert(user,new UserDto())).collect(Collectors.toList());

    }

    @Override
    public UserDto save(UserDto userDto) {

         userRepository.save(mapperUtil.convert(userDto,new User()));
         return userDto;
    }

    @Override
    public UserDto findUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User " + id + " not found"));


        return mapperUtil.convert(user,new UserDto());
    }
}
