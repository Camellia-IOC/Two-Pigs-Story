package org.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.demo.entity.PO.UserPO;

@Mapper
public interface AuthenticationMapper extends BaseMapper<UserPO> {
    /**
     * 获取指定用户密码
     *
     * @param userId 用户ID
     *
     * @return 用户信息
     */
    @Select("SELECT password FROM users WHERE id = #{userId}")
    UserPO getPasswordById (@Param("userId") Integer userId);
}
