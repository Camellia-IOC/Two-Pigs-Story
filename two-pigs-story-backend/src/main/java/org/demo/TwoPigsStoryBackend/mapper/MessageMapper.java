package org.demo.TwoPigsStoryBackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.demo.TwoPigsStoryBackend.entity.PO.MessagePO;
import org.demo.TwoPigsStoryBackend.entity.VO.message.MessageResponseVO;

import java.util.List;

@Mapper
public interface MessageMapper extends BaseMapper<MessagePO> {
    /**
     * 获取消息列表
     *
     * @param receiverId 消息接收者ID
     *
     * @return 消息列表
     */
    @Select("SELECT messages.*,users.avatar as avatar,users.username as name FROM messages,users WHERE " +
                    "messages.receiver = #{receiverId} AND messages.receiver = users.id")
    List<MessageResponseVO> getMessageListByReceiverId (@Param("receiverId") Integer receiverId);
}
