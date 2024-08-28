package org.demo.entity.DTO.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginRequestDTO
{
    @JsonProperty("userId")
    private Integer userId;
    
    @JsonProperty("password")
    private String password;
}
