package com.record.mcj.service.user;

import com.record.mcj.domain.user.User;
import com.record.mcj.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
<<<<<<< HEAD
public class DomainUserService implements UserService{
=======
public class DomainUserService implements UserService {
>>>>>>> origin/MCJ-13

    private final UserRepository userRepository;


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> origin/MCJ-13
