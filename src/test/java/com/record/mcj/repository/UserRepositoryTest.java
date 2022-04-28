package com.record.mcj.repository;

import com.record.mcj.data.Address;
import com.record.mcj.data.Role;
import com.record.mcj.entity.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringBootTest
@AutoConfigureTestDatabase(replace = NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @Transactional
    void 유저_생성_테스트(){
        final User save = userRepository.save(new User("name", "email", "password", new Address("A", "B", "C"), LocalDateTime.now(), Role.user));

        final User user = userRepository.findById(save.getId()).orElseThrow();

        assertThat(user.getId()).isNotNull();

    }

    @Test
    @Transactional
    void 유저_삭제_테스트(){
        final User save = userRepository.save(new User("name", "email", "password", new Address("A", "B", "C"), LocalDateTime.now(), Role.user));

        userRepository.delete(save);

        Assertions.assertThrows(NoSuchElementException.class , () -> userRepository.findById(save.getId()).orElseThrow());

    }


}