package com.record.mcj.entity;

import com.record.mcj.data.Address;
import com.record.mcj.data.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserTest {

    @Test
    void 사용자_이름은_필수() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, "email", "password", new Address("A", "B", "C"), LocalDateTime.now(), Role.user));
        assertThrows(IllegalArgumentException.class, () -> new User("", "email", "password", new Address("A", "B", "C"), LocalDateTime.now(), Role.user));

    }

    @Test
    void 사용자_이메일은_필수() {
        assertThrows(IllegalArgumentException.class, () -> new User("name", null, "password", new Address("A", "B", "C"), LocalDateTime.now(), Role.user));
        assertThrows(IllegalArgumentException.class, () -> new User("name", "", "password", new Address("A", "B", "C"), LocalDateTime.now(), Role.user));

    }


    @Test
    void 사용자_패스워드는_필수() {
        assertThrows(IllegalArgumentException.class, () -> new User("name", "email", null, new Address("A", "B", "C"), LocalDateTime.now(), Role.user));
        assertThrows(IllegalArgumentException.class, () -> new User("name", "email", "", new Address("A", "B", "C"), LocalDateTime.now(), Role.user));

    }

}