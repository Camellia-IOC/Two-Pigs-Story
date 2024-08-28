package org.demo.entity.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("zone")
public class ZonePO {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    
    @TableField("intro")
    private String introduction;
    
    @TableField("owner")
    private Integer owner;
    
    @TableField("mate")
    private Integer mate;
    
    @TableField("create_time")
    private LocalDateTime createTime;
    
    @TableField("status")
    private Integer status;
}
