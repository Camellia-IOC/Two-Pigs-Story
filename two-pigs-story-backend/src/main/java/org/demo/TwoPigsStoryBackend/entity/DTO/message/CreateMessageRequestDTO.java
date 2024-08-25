package org.demo.TwoPigsStoryBackend.entity.DTO.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateMessageRequestDTO {
    @JsonProperty("type")
    private Integer type;
    
    @JsonProperty("origin")
    private Integer origin;
    
    @JsonProperty("receiver")
    private Integer receiver;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("content")
    private String content;
}
