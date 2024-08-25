package org.demo.TwoPigsStoryBackend.entity.VO.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.demo.TwoPigsStoryBackend.entity.PO.ZoneInvitationPO;

import java.util.List;

@Data
public class InvitationListResponseVO {
    @JsonProperty("list")
    private List<ZoneInvitationPO> invitationList;
}
