package com.clicklearner.ms_cours.openfeign;

import com.clicklearner.ms_cours.dto.user.ProfDto;
import com.clicklearner.ms_cours.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "ms-users", url = "http://localhost:8084/ms-users/api/v1/user")
public interface UserServiceClient {

    @GetMapping("/{userId}")
    Optional<ProfDto> getUserById(@PathVariable("userId") int userId);

}
