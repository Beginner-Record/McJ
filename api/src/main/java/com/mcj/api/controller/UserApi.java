package com.mcj.api.controller;


import com.mcj.api.controller.dto.UserCreateDto.UserCreateRequest;
import com.mcj.api.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mcj.api.controller.dto.UserCreateDto.UserCreateData;
import static com.mcj.api.controller.dto.UserCreateDto.UserCreateResponse;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    /*
     * 유저 생성
     */
    @PostMapping
    public UserCreateResponse createUser(@RequestBody UserCreateRequest request) {
        return new UserCreateResponse(
                UserCreateData.create(userService.create(request.toEntity())));
    }

}
