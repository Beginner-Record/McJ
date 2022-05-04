package com.record.mcj.service.user;

import com.record.mcj.domain.user.User;
import com.record.mcj.domain.user.UserRepository;
import com.record.mcj.fixture.UserFixture;
import com.record.mcj.support.BaseServiceTest;
<<<<<<< HEAD
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
=======
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
>>>>>>> origin/MCJ-13

class DomainUserServiceTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void 유저_생성_성공() {
        final User user = userService.create(UserFixture.userCreate());

        final User findUser = userRepository.findById(user.getId()).orElseThrow();

        assertThat(user).isEqualTo(findUser);
    }

}