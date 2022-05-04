package com.record.mcj.api;

import com.record.mcj.api.dto.UserCreateDto.UserCreateRequest;
import com.record.mcj.api.dto.UserCreateDto.UserCreateResponse;
import com.record.mcj.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.record.mcj.api.dto.UserCreateDto.UserCreateData.create;

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
                create(userService.create(request.toEntity())));
    }

}
