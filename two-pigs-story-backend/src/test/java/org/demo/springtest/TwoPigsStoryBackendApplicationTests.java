package org.demo.springtest;

import jakarta.annotation.Resource;
import org.demo.TwoPigsStoryBackend.TwoPigsStoryBackendApplication;
import org.demo.TwoPigsStoryBackend.entity.PO.UserPO;
import org.demo.TwoPigsStoryBackend.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = TwoPigsStoryBackendApplication.class)
@RunWith(SpringRunner.class)
class TwoPigsStoryBackendApplicationTests
{
    @Resource
    private UserMapper userMapper;
    
    @Test
    public void selectTest(){
        UserPO userPO = userMapper.getPasswordById(1);
        System.out.println(userPO);
    }
}
