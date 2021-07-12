package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ControlleraspectApplicationTests {

    @Test
    void contextLoads() {
        String s = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(s.length());
        System.out.println(s);
        System.out.println(System.currentTimeMillis());
    }

}
