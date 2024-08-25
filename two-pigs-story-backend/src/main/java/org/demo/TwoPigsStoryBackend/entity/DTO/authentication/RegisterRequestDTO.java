package org.demo.TwoPigsStoryBackend.entity.DTO.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterRequestDTO
{
    @JsonProperty("username")
    private String userName;
    
    @JsonProperty("password")
    private String password;
}
