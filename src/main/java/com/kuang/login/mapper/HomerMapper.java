package com.kuang.login.mapper;

import com.kuang.login.entity.HomerEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HomerMapper {

    HomerEntity findByHomerId(@Param("homerId") String homerId);
}