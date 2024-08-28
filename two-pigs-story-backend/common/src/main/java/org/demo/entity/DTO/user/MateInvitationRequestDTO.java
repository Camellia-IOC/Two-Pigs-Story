package org.demo.entity.DTO.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MateInvitationRequestDTO {
    @JsonProperty("senderId")
    private Integer senderId;
    
    @JsonProperty("receiverId")
    private Integer receiverId;
}
