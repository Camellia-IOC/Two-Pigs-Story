package org.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.demo.entity.PO.ZoneInfoPO;

@Mapper
public interface ZoneInfoMapper extends BaseMapper<ZoneInfoPO> {
    /**
     * 根据空间ID获取空间信息
     *
     * @param zoneId 空间ID
     *
     * @return 所提供空间ID的空间信息
     */
    @Select("SELECT * FROM zone_info WHERE zone = #{zoneId}")
    ZoneInfoPO getZoneInfoByZoneId (@Param("zoneId") Integer zoneId);
    
//    @Update("UPDATE zone_info SET zone=#{}  WHERE zone = #{}")
//    int updateZoneInfoByZoneId(ZoneInfoPO zoneInfoPO);
}
