package org.demo.springtest.entity.DTO.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginRequestDTO
{
    @JsonProperty("userID")
    private Integer userID;
    
    @JsonProperty("password")
    private String password;
}
