package com.kuang.login.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HomerMapperTest {

    @Autowired
    private HomerMapper homerMapper;

    @Test
    public void findByHomerId() {
        assertNotNull(homerMapper.findByHomerId("1234"));
    }
}