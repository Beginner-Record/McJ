package com.mcj.api.service.user;

import com.mcj.core.domain.user.User;

public interface UserService {

    /**
     * 보스 생성
     */
    User create(User user);

}