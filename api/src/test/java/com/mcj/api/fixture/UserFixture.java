package com.mcj.api.fixture;

import com.mcj.core.domain.user.User;
import com.mcj.core.domain.user.UserRole;
import com.mcj.core.embed.Address;

import java.time.OffsetDateTime;

public class UserFixture {

    public static User userCreate() {
        final Address address = new Address("A", "b", "c");
        final OffsetDateTime now = OffsetDateTime.now();
        return new User("a", "pss", "email", "nickname", address, now, UserRole.USER);
    }

}
