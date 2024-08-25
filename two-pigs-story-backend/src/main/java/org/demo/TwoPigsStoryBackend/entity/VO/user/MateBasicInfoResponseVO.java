package org.demo.TwoPigsStoryBackend.entity.VO.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MateBasicInfoResponseVO {
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("avatar")
    private String avatar;
}
