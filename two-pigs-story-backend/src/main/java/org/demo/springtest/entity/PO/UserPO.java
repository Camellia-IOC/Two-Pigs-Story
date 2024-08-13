package org.demo.springtest.entity.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("users")
public class UserPO
{
    @TableId(value = "id", type = IdType.AUTO)
    Long id;
    
    @TableField("username")
    String username;
    
    @TableField("password")
    String password;
    
    @TableField("intro")
    String introduction;
    
    @TableField("sex")
    Integer sex;
    
    @TableField("zone")
    Long zone;
    
    @TableField("mate")
    Long mate;
    
    @TableField("birthday")
    Date birthday;
}
