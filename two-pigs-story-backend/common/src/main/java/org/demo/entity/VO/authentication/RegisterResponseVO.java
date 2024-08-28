package org.demo.entity.VO.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterResponseVO {
    /**
     * 用户ID
     */
    @JsonProperty("userId")
    private Integer userId;
}
