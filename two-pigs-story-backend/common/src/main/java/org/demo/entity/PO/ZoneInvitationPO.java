package org.demo.entity.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("zone_invitations")
public class ZoneInvitationPO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    @TableField("sender")
    private Integer sender;
    
    @TableField("receiver")
    private Integer receiver;
    
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    
    @TableField("handle_time")
    private LocalDateTime handleTime;
    
    @TableField("status")
    private Integer status;
}
