package org.demo.entity.DTO.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CloseZoneRequestDTO {
    @JsonProperty("id")
    private Integer id;
}
