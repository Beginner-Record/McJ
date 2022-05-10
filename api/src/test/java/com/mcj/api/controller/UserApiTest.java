package com.mcj.api.controller;

import com.mcj.api.controller.dto.UserCreateDto.UserCreateRequest;
import com.mcj.api.support.BaseApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.time.OffsetDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserApiTest extends BaseApiTest {

    @Test
    void 유저_생성_성공() throws Exception {
        final UserCreateRequest request = new UserCreateRequest(
                "id", "1234", "email", "name",
                "A", "B", "C", OffsetDateTime.now());

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.user.textId").value("id"),
                        jsonPath("$.user.email").value("email"),
                        jsonPath("$.user.nickName").value("name"),
                        jsonPath("$.user.address.zipcode").value("A"),
                        jsonPath("$.user.address.city").value("B"),
                        jsonPath("$.user.address.street").value("C"),
                        jsonPath("$.user.birthday").isNotEmpty(),
                        jsonPath("$.user.createAt").isNotEmpty()
                );
    }

}