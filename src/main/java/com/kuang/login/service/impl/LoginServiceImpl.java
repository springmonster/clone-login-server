package com.kuang.login.service.impl;

import com.kuang.login.entity.UserEntity;
import com.kuang.login.repository.CacheRepository;
import com.kuang.login.repository.UserRepository;
import com.kuang.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheRepository cacheRepository;

    @Override
    public UserEntity findByUserId(String homerId) {
        return userRepository.findByUserId(homerId);
    }

    @Override
    public String generateUserToken() {
        return cacheRepository.setAndReturnUserToken();
    }
}
