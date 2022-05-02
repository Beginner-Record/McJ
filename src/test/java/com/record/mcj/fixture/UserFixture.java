package com.record.mcj.fixture;

import com.record.mcj.embed.Address;
import com.record.mcj.domain.user.UserRole;
import com.record.mcj.domain.user.User;

import java.time.OffsetDateTime;

public class UserFixture {

    public static User userCreate(){
        final Address address = new Address("A", "b", "c");
        final OffsetDateTime now = OffsetDateTime.now();
        return new User("a", "pss", "email", "nickname", address, now, UserRole.USER);
    }

}
