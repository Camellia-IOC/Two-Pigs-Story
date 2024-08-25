package org.demo.TwoPigsStoryBackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.demo.TwoPigsStoryBackend.entity.PO.ZoneInvitationPO;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ZoneInvitationMapper extends BaseMapper<ZoneInvitationPO> {
    /**
     * 根据被邀请用户ID获取该用户的被邀请列表
     *
     * @param userId 被邀请用户的ID
     *
     * @return 邀请信息列表
     */
    // TODO:会遇到“非法SQL，SQL未使用到索引”的问题
    @Select("SELECT * FROM invitations WHERE receiver = #{userId}")
    List<ZoneInvitationPO> getInvitationListByUserId (@Param("userId") Integer userId);
    
    /**
     * 获取邀请信息状态
     *
     * @param id 邀请信息ID
     *
     * @return 邀请信息状态
     */
    @Select("SELECT status FROM invitations WHERE id = #{id}")
    Integer getInvitationStatusById (@Param("id") Integer id);
    
    /**
     * 处理邀请信息
     *
     * @param invitationId 邀请ID
     * @param status       同意状态
     * @param time         处理时间
     *
     * @return 是否成功更新
     */
    @Update("UPDATE invitations SET status = #{status}, handle_time = #{time} WHERE id = #{invitationId}")
    int updateInvitationStatus (@Param("invitationId") Integer invitationId, @Param("status") Integer status, @Param("time") LocalDateTime time);
    
}
