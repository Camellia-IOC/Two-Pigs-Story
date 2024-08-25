package org.demo.TwoPigsStoryBackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.demo.TwoPigsStoryBackend.entity.PO.ZonePO;
import org.demo.TwoPigsStoryBackend.entity.VO.zone.ZoneMemberResponseVO;

@Mapper
public interface ZoneMapper extends BaseMapper<ZonePO> {
    /**
     * 分配空间
     *
     * @param zone  空间ID
     * @param owner 拥有者ID
     * @param mate  伴侣ID
     *
     * @return 是否成功分配
     */
    @Update("UPDATE users SET zone = #{zone} WHERE id IN (#{owner}, #{mate})")
    int assignZone (@Param("zone") Integer zone, @Param("owner") Integer owner, @Param("mate") Integer mate);
    
    /**
     * 撤销空间分配
     *
     * @param owner 拥有者ID
     * @param mate  伴侣ID
     *
     * @return 是否成功撤销
     */
    @Update("UPDATE users SET zone = null WHERE id IN (#{owner}, #{mate})")
    int revokeZone (@Param("owner") Integer owner, @Param("mate") Integer mate);
    
    /**
     * 根据空间ID获取空间所属用户ID
     *
     * @param zone 空间ID
     *
     * @return 空间所属用户ID
     */
    @Select("SELECT owner,mate FROM zone WHERE id = #{zone}")
    ZoneMemberResponseVO getZoneMemberByZoneId (@Param("zone") Integer zone);
    
    /**
     * 关闭空间
     *
     * @param id 空间ID
     *
     * @return 是否成功关闭
     */
    @Delete("DELETE FROM zone WHERE id = #{id}")
    int closeZone (@Param("id") Integer id);
}
