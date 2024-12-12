package com.clicklearner.msusers.controller;

import com.clicklearner.msusers.model.User;
import com.clicklearner.msusers.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    public UserServiceImpl userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@RequestParam int userId){
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @PostMapping("/createuser")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateuser/{userId}")
    public ResponseEntity<?> updateUser(@RequestParam int userId, @RequestBody User user){
        userService.updateUser(userId, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@RequestParam int userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
