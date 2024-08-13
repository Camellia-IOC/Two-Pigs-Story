package org.demo.springtest.entity.VO.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterResponseVO
{
    /**
     * 用户ID
     */
    @JsonProperty("userID")
    private Long userID;
}
