package com.tsg.controller;

import com.tsg.dto.UserDto;
import com.tsg.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> listAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping()
    public void saveUser(@RequestBody UserDto userDto){
        userService.save(userDto);

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findByUserId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(userService.findUser(id));
    }
}
