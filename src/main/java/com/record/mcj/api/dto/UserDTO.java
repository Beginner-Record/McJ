package com.record.mcj.api.dto;

import com.record.mcj.data.Address;
import com.record.mcj.data.Role;
import com.record.mcj.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class UserDTO {


    @Getter
    @AllArgsConstructor
    public static class UserCreateRequest {

        private String name;

        private String email;

        private String password;

        private Address address;

        private LocalDateTime birthday;

        public User toEntity() {
            return new User(name, email, password, address, birthday, Role.user);
        }

    }


    @Getter
    @AllArgsConstructor
    public static class UserCreateResponse {
        private UserCreateData user;
    }

    @Getter
    @AllArgsConstructor
    public static class UserCreateData {

        private String name;

        private String email;

        private String password;

        private Address address;

        private LocalDateTime birthday;

        private String role;


        public UserCreateData(User user) {
            this.name = user.getName();
            this.email = user.getEmail();
            this.password = user.getPassword();
            this.address = user.getAddress();
            this.birthday = user.getBirthday();
            this.role = user.getRole().name();

        }

    }

}
