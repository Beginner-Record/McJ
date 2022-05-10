package com.mcj.core.user.service;

import com.mcj.core.user.domain.User;
import com.mcj.core.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DomainUserService implements UserService {

    private final UserRepository userRepository;


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

}