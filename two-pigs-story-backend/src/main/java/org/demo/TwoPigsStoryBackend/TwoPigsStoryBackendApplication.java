package org.demo.TwoPigsStoryBackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.demo.TwoPigsStoryBackend.mapper")
public class TwoPigsStoryBackendApplication
{
    
    public static void main (String[] args)
    {
        SpringApplication.run(TwoPigsStoryBackendApplication.class, args);
    }
    
}
