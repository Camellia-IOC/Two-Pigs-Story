package org.demo.entity.DTO.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LogoutRequestDTO {
    @JsonProperty("userId")
    private Integer userId;
}
