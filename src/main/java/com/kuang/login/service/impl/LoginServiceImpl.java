package com.kuang.login.service.impl;

import com.kuang.login.entity.UserEntity;
import com.kuang.login.repository.UserRepository;
import com.kuang.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findByHomerId(String homerId) {
        return userRepository.findByUserId(homerId);
    }
}
