package com.record.mcj.api.user.dto;

import com.record.mcj.data.Address;
import com.record.mcj.data.Role;
import com.record.mcj.domain.user.User;

import java.time.LocalDateTime;

public class CreateUserDTO {

    public record UserCreateRequest(
            String name,
            String email,
            String password,
            Address address,
            LocalDateTime birthday
    ) {

        public User toEntity() {
            return new User(name, email, password, address, birthday, Role.USER);
        }
    }

    public record UserCreateResponse(UserCreateData user) {
    }

    public record UserCreateData(
            String name,
            String email,
            String password,
            Address address,
            LocalDateTime birthday,
            String role
    ) {

        public static UserCreateData createUserCreateData(User user) {
            return new UserCreateData(
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getAddress(),
                    user.getBirthday(),
                    user.getRole().name()
            );
        }
    }
}
