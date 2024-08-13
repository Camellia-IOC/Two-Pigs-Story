package org.demo.springtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.demo.springtest.mapper")
public class TwoPigsStoryBackendApplication
{
    
    public static void main (String[] args)
    {
        SpringApplication.run(TwoPigsStoryBackendApplication.class, args);
    }
    
}
