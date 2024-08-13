package org.demo.springtest;

import jakarta.annotation.Resource;
import org.demo.springtest.entity.PO.UserPO;
import org.demo.springtest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = SpringTestApplication.class)
@RunWith(SpringRunner.class)
class SpringTestApplicationTests
{
    @Resource
    private UserMapper userMapper;
    
    @Test
    public void selectTest(){
        UserPO userPO = userMapper.selectPasswordById(1);
        System.out.println(userPO);
    }
}
