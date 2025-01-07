package com.clicklearner.msprogression.openfeign;

import com.clicklearner.msprogression.dto.CoursDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "ms-cours", url = "http://localhost:8088/ms-cours/api/v1/cours")
public interface CoursServiceClient {

    @GetMapping("/{coursId}")
    Optional<CoursDto> getCoursById(@PathVariable("coursId") int userId);

}
