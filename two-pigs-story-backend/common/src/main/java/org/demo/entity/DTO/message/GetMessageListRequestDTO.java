package org.demo.entity.DTO.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetMessageListRequestDTO {
    @JsonProperty("id")
    private Integer id;
}
