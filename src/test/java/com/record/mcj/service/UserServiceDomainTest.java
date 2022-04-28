package com.record.mcj.service;

import com.record.mcj.data.Address;
import com.record.mcj.data.Role;
import com.record.mcj.entity.User;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class UserServiceDomainTest {

    @Autowired
    UserServiceDomain userServiceDomain;

    @Autowired
    EntityManager em;


    @Test
    void 유저_생성_테스트(){
        final User user = new User("name", "email", "password", new Address("A", "B", "C"), LocalDateTime.now(), Role.user);
        userServiceDomain.create(user);

        final User findUser = em.find(User.class, user.getId());

        Assertions.assertEquals(user, findUser);

    }

}