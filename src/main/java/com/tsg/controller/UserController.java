package com.tsg.controller;

import com.tsg.dto.UserDto;
import com.tsg.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> listAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping()
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {

        UserDto savedUser = userService.save(userDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")  // append id variable
                .buildAndExpand(savedUser.getId())  // replace it with id
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findByUserId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.findUser(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") Integer id){
        return ResponseEntity.ok(userService.delete(id));
    }
}
