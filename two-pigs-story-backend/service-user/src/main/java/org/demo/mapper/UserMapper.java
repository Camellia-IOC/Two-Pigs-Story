package org.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.demo.entity.PO.UserPO;
import org.demo.entity.VO.user.MateBasicInfoResponseVO;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
    /**
     * 获取指定用户密码
     *
     * @param userId 用户ID
     *
     * @return 用户信息
     */
    @Select("SELECT password FROM users WHERE id = #{userId}")
    UserPO getPasswordById (@Param("userId") Integer userId);
    
    /**
     * 获取所有用户信息
     *
     * @return 用户信息List
     */
    @Select("SELECT * from users")
    List<UserPO> selectAllUser ();
    
    /**
     * 获取指定用户可明文显示的信息
     *
     * @param userId 用户ID
     *
     * @return 用户信息
     */
    @Select("SELECT id,username,avatar,intro,sex,birthday,zone,mate FROM users WHERE id = #{userId}")
    UserPO getUserInfoById (@Param("userId") Integer userId);
    
    /**
     * 获取伴侣基本信息
     *
     * @param mateId 伴侣ID
     *
     * @return 伴侣基本信息
     */
    @Select("SELECT id,username,avatar FROM users WHERE id = #{mateId}")
    MateBasicInfoResponseVO getMateInfoById (@Param("mateId") Integer mateId);
}
