package org.demo.springtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.demo.springtest.entity.PO.UserPO;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserPO>
{
    @Select("SELECT password FROM users WHERE id = #{userId}")
    UserPO selectPasswordById(@Param("userId") Integer userId);
    
    @Select("SELECT * from users")
    List<UserPO> selectAllUser();
}
