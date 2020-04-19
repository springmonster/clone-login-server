package com.kuang.login.service;

import com.kuang.login.entity.UserEntity;

public interface LoginService {

    UserEntity findByHomerId(String homerId);

    String generateUserToken();
}
