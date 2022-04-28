package com.record.mcj.service;

import com.record.mcj.entity.user.User;
import com.record.mcj.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserServiceDomain implements UserService {

    private final UserRepository userRepository;


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }


}
