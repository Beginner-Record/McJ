package com.mcj.core.user.service;

import com.mcj.core.user.domain.User;

public interface UserService {

    /**
     * 보스 생성
     */
    User create(User user);

}