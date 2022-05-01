package com.record.mcj.api.user;


import com.record.mcj.api.user.dto.CreateUserDTO.UserCreateRequest;
import com.record.mcj.api.user.dto.CreateUserDTO.UserCreateResponse;
import com.record.mcj.service.user.UserServiceDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.record.mcj.api.user.dto.CreateUserDTO.UserCreateData.createUserCreateData;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAPI {

    private final UserServiceDomain userServiceDomain;

    @PostMapping
    public UserCreateResponse createUser(@RequestBody UserCreateRequest userCreateRequest) {
        System.out.println(userCreateRequest.name());
        return new UserCreateResponse(
                createUserCreateData(userServiceDomain.create(userCreateRequest.toEntity())));
    }
}
