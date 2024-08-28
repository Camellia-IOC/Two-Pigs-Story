package org.demo.entity.DTO.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HandleMateInvitationRequestDTO {
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("sender")
    private Integer sender;
    
    @JsonProperty("receiver")
    private Integer receiver;
    
    @JsonProperty("status")
    private Integer status;
    
}
