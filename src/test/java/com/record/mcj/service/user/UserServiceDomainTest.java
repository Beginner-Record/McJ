package com.record.mcj.service.user;

import com.record.mcj.data.Address;
import com.record.mcj.data.Role;
import com.record.mcj.domain.user.User;
import com.record.mcj.support.BaseServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

class UserServiceDomainTest extends BaseServiceTest {

    @Autowired
    UserServiceDomain userServiceDomain;

    @Autowired
    EntityManager em;

    @Test
    void 유저_생성_테스트() {
        final User user = new User("name", "email", "password", new Address("A", "B", "C"), LocalDateTime.now(), Role.user);
        userServiceDomain.create(user);

        final User findUser = em.find(User.class, user.getId());

        Assertions.assertEquals(user, findUser);
    }
}