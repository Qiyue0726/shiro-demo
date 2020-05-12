package org.sakura.shirodemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: yujianhao
 * @ClassName: UserServiceTest
 * @Description: 描述
 * @CreateDate: 2020-05-12 22:52
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    void selectList() {
        userService.selectList();
    }
}