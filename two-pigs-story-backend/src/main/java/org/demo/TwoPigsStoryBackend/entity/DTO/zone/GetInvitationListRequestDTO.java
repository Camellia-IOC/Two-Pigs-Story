package org.demo.TwoPigsStoryBackend.entity.DTO.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetInvitationListRequestDTO {
    @JsonProperty("id")
    private Integer id;
}
