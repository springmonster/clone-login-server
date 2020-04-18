package com.kuang.login.service.impl;

import com.kuang.login.entity.HomerEntity;
import com.kuang.login.mapper.HomerMapper;
import com.kuang.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private HomerMapper homerMapper;

    @Override
    public HomerEntity findByHomerId(String homerId) {
        return homerMapper.findByHomerId(homerId);
    }
}
