package com.clicklearner.ms_devoir.openfeign;

import com.clicklearner.ms_devoir.DTO.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

//use caching later for faster response
@FeignClient(name = "ms-users", url="http://localhost:8084/api/v1/user")
public interface UserServiceClient {

    @GetMapping("/{userId}")
    public Optional<UserDto> getUserById(@PathVariable("userId") int userId);
}
