package org.demo.entity.VO.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.demo.entity.PO.ZoneInvitationPO;

import java.util.List;

@Data
public class InvitationListResponseVO {
    @JsonProperty("list")
    private List<ZoneInvitationPO> invitationList;
}
