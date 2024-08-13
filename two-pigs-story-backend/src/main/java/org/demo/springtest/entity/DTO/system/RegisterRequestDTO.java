package org.demo.springtest.entity.DTO.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterRequestDTO
{
    @JsonProperty("userName")
    private String userName;
    
    @JsonProperty("password")
    private String password;
}
