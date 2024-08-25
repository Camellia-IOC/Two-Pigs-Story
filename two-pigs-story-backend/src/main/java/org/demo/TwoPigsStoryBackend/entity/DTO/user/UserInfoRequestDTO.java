package org.demo.TwoPigsStoryBackend.entity.DTO.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfoRequestDTO {
    @JsonProperty("userId")
    private Integer userId;
}
