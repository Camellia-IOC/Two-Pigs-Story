package org.demo.entity.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("zone_info")
public class ZoneInfoPO {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    
    @TableField("zone")
    private Integer zoneId;
    
    @TableField("intro")
    private String introduction;
    
    @TableField("anniversary")
    private Date anniversary;
    
    @TableField("pictures")
    private Integer pictures;
    
    @TableField("footprint")
    private Integer footprint;
}
