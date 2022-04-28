package com.record.mcj.api;


import com.record.mcj.api.dto.UserDTO.UserCreateData;
import com.record.mcj.api.dto.UserDTO.UserCreateRequest;
import com.record.mcj.api.dto.UserDTO.UserCreateResponse;
import com.record.mcj.service.UserServiceDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAPI {

    private final UserServiceDomain userServiceDomain;

    @PostMapping
    public UserCreateResponse createUser(@RequestBody UserCreateRequest userCreateRequest) {
        System.out.println(userCreateRequest.getName());
        return new UserCreateResponse(
                new UserCreateData(userServiceDomain.create(userCreateRequest.toEntity())));


    }

}
