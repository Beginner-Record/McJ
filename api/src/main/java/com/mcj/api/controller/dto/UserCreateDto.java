package com.mcj.api.controller.dto;

import com.mcj.core.user.domain.User;
import com.mcj.core.user.domain.UserRole;
import com.mcj.core.embed.Address;

import java.time.OffsetDateTime;

public class UserCreateDto {

    public record UserCreateRequest(
            String textId,
            String password,
            String email,
            String nickName,
            String zipcode,
            String city,
            String street,
            OffsetDateTime birthday
    ) {
        public User toEntity() {
            return new User(
                    this.textId,
                    this.password,
                    this.email,
                    this.nickName,
                    new Address(this.zipcode, this.city, this.street),
                    this.birthday,
                    UserRole.USER
            );
        }
    }

    public record UserCreateResponse(UserCreateData user) {
    }

    public record UserCreateData(
            String textId,
            String email,
            String nickName,
            Address address,
            OffsetDateTime birthday,
            OffsetDateTime createAt
    ) {
        public static UserCreateData create(User user) {
            return new UserCreateData(
                    user.getTextId(),
                    user.getEmail(),
                    user.getNickName(),
                    user.getAddress(),
                    user.getBirthday(),
                    user.getCreateAt()
            );
        }
    }

}
