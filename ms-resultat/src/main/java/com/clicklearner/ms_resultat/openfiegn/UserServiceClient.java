package com.clicklearner.ms_resultat.openfiegn;

import com.clicklearner.ms_resultat.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "mc-users", url = "http://localhost:8084/api/v1/user")
public interface UserServiceClient {

    @GetMapping("/{userId}")
    public Optional<UserDto> getUserById(@PathVariable("userId") int userId);
}
