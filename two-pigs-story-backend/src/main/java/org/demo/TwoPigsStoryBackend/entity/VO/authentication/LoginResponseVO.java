package org.demo.TwoPigsStoryBackend.entity.VO.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponseVO {
    @JsonProperty("permission")
    private Boolean permission;
}
