package org.demo.TwoPigsStoryBackend.entity.DTO.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddFriendRequestDTO {
    @JsonProperty("userId")
    private Integer userId;
    
    @JsonProperty("friendId")
    private Integer friendId;
}
