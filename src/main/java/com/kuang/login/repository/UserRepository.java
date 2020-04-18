package com.kuang.login.repository;

import com.kuang.login.entity.UserEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    UserEntity findByUserId(@Param("userId") String userId);
}