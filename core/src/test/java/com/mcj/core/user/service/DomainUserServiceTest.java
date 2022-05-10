package com.mcj.core.user.service;

import com.mcj.core.fixture.UserFixture;
import com.mcj.core.support.BaseServiceTest;
import com.mcj.core.user.domain.User;
import com.mcj.core.user.domain.UserRepository;
import com.mcj.core.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

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