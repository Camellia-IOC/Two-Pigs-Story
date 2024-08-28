package org.demo.entity.DTO.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConfigureZoneRequestDTO {
    @JsonProperty("intro")
    private String introduction;
}
