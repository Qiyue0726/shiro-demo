package org.sakura.shirodemo.controller;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: yujianhao
 * @ClassName: shiroControllerTest
 * @Description: 描述
 * @CreateDate: 2020-05-12 22:54
 */
@SpringBootTest
class shiroControllerTest {

    @Autowired
    shiroController shiroController;

    @Test
    void test1() {
        shiroController.test();
    }
}