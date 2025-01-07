package com.clicklearner.msprogression.openfeign;

import com.clicklearner.msprogression.dto.CoursDto;
import com.clicklearner.msprogression.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "ms-users", url = "http://localhost:8084/ms-users/api/v1/user")
public interface UserServiceClient {

    @GetMapping("/{userId}")
    Optional<UserDto> getUserById(@PathVariable int userId);

}
