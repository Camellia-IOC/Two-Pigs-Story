package org.demo.entity.DTO.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateZoneRequestDTO {
    @JsonProperty("owner")
    private Integer owner;
    
    @JsonProperty("mate")
    private Integer mate;
    
    @JsonProperty("create_time")
    private LocalDateTime createTime;
}
