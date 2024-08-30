package org.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.demo.entity.PO.FriendInvitationPO;

import java.time.LocalDateTime;
import java.util.List;

public interface FriendInvitationMapper extends BaseMapper<FriendInvitationPO> {
    /**
     * 根据被邀请用户ID获取该用户的被邀请列表
     *
     * @param userId 被邀请用户的ID
     *
     * @return 邀请信息列表
     */
    @Select("SELECT * FROM friend_invitations WHERE friend = #{userId}")
    List<FriendInvitationPO> getInvitationListByUserId (@Param("userId") Integer userId);
    
    /**
     * 获取邀请信息状态
     *
     * @param id 邀请信息ID
     *
     * @return 邀请信息状态
     */
    @Select("SELECT status FROM friend_invitations WHERE id = #{id}")
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
    @Update("UPDATE friend_invitations SET status = #{status}, handle_time = #{time} WHERE id = #{invitationId}")
    int updateInvitationStatus (@Param("invitationId") Integer invitationId, @Param("status") Integer status, @Param("time") LocalDateTime time);
}
