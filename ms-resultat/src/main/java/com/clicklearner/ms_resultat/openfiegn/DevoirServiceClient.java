package com.clicklearner.ms_resultat.openfiegn;

import com.clicklearner.ms_resultat.Dto.DevoirDto;
import com.clicklearner.ms_resultat.Dto.UserResponseByDevoirRequestDto;
import com.clicklearner.ms_resultat.Dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ms-devoir", url="http://localhost:8086/api/v1/")
public interface DevoirServiceClient {
    @GetMapping("devoir/{devoirId}")
    Optional<DevoirDto> getDevoirById(@PathVariable("devoirId") int devoirId);

    @GetMapping("userresponse/devoir")
    Optional<List<UserResponseDto>> getUserSubmissionForDevoirByDevoirId(@RequestParam("userId") int userId,
                                                                         @RequestParam("devoirId") int devoirId);


}
