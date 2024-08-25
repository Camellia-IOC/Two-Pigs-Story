package org.demo.TwoPigsStoryBackend.entity.VO.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ZoneMemberResponseVO {
    @JsonProperty("owner")
    private Integer owner;
    
    @JsonProperty("mate")
    private Integer mate;
}
