package com.clicklearner.msusers.service;

import com.clicklearner.msusers.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public User getUserById(int userId);
    public void createUser(User user);
    public void updateUser(int userId, User user);
    public void deleteUser(int userId);
}
