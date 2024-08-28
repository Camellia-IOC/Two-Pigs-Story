package org.demo.entity.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("friends")
public class FriendPO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    @TableField("user")
    private Integer user;
    
    @TableField("friend")
    private Integer friend;
    
    @TableField("time")
    private LocalDateTime time;
    
}
