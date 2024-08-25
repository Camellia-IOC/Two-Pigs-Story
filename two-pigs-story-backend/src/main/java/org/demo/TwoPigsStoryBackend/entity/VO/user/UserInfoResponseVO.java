package org.demo.TwoPigsStoryBackend.entity.VO.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class UserInfoResponseVO {
    @JsonProperty("id")
    private long id;
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("avatar")
    private String avatar;
    
    @JsonProperty("intro")
    private String intro;
    
    @JsonProperty("sex")
    private int sex;
    
    @JsonProperty("birthday")
    private Date birthday;
    
    @JsonProperty("zone")
    private long zone;
    
    @JsonProperty("mate")
    private MateBasicInfoResponseVO mate;
}
