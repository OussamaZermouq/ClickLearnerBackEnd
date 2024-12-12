package com.clicklearner.msusers.service;

import com.clicklearner.msusers.model.User;
import com.clicklearner.msusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    public UserRepository userRepository;
    @Override
    public User getUserById(int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(int userId, User user) {
        Optional<User> userToUpdate = userRepository.findById(userId);
        if (userToUpdate.isPresent()) {
            userRepository.save(user);
        }
    }
    @Override
    public void deleteUser(int userId) {
        Optional<User> userToDelete = userRepository.findById(userId);
        if(userToDelete.isPresent()){
            userRepository.delete(userToDelete.get());
        }
    }
}
