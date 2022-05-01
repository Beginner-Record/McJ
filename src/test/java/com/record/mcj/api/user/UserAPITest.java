package com.record.mcj.api.user;

import com.record.mcj.api.user.dto.CreateUserDTO.UserCreateRequest;
import com.record.mcj.data.Address;
import com.record.mcj.support.BaseApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserAPITest extends BaseApiTest {

    @Test
    void 유저_생성() throws Exception {
        final LocalDateTime now = LocalDateTime.now();
        final Address address = new Address("A", "B", "C");
        final UserCreateRequest userCreateRequest = new UserCreateRequest("이름", "이멜", "pss", address, now);

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userCreateRequest)))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.user.name").value("이름"),
                        jsonPath("$.user.email").value("이멜"),
                        jsonPath("$.user.password").value("pss"),
                        jsonPath("$.user.address.zipcode").value("A"),
                        jsonPath("$.user.birthday").value(now.toString()),
                        jsonPath("$.user.role").value("USER"));
    }
}