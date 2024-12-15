package com.clicklearner.msusers.controller;

import com.clicklearner.msusers.Dto.UserDto;
import com.clicklearner.msusers.model.User;
import com.clicklearner.msusers.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    public UserServiceImpl userService;

    @Autowired
    public ModelMapper modelMapper;
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userId){
        return ResponseEntity.ok().body(convertToDto(userService.getUserById(userId)));
    }

    @PostMapping("/createuser")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateuser/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody User user){
        userService.updateUser(userId, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }


    public UserDto convertToDto(User user){
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
