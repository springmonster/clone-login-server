package com.kuang.login.service;

import com.kuang.login.entity.HomerEntity;

public interface LoginService {

    HomerEntity findByHomerId(String homerId);
}
