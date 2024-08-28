package org.demo.entity.PO;

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
    Integer id;
    
    @TableField("username")
    String username;
    
    @TableField("password")
    String password;
    
    @TableField("avatar")
    String avatar;
    
    @TableField("intro")
    String introduction;
    
    @TableField("sex")
    Integer sex;
    
    @TableField("zone")
    Integer zone;
    
    @TableField("mate")
    Integer mate;
    
    @TableField("birthday")
    Date birthday;
    
    @TableField("token")
    String token;
}
