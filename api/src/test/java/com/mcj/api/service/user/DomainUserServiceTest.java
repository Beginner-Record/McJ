package com.mcj.api.service.user;

import com.mcj.core.domain.user.User;
import com.mcj.core.domain.user.UserRepository;
import com.mcj.api.fixture.UserFixture;
import com.mcj.api.support.BaseServiceTest;
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