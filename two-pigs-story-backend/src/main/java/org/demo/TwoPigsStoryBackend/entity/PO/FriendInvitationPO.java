package org.demo.TwoPigsStoryBackend.entity.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("friend_invitations")
public class FriendInvitationPO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    @TableField("user")
    private Integer user;
    
    @TableField("friend")
    private Integer friend;
    
    @TableField("create_time")
    private LocalDateTime sendTime;
    
    @TableField("handle_time")
    private LocalDateTime joinTime;
    
    @TableField("status")
    private Integer status;
}
