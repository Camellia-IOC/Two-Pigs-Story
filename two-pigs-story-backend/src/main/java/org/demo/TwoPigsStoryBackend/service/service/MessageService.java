package org.demo.TwoPigsStoryBackend.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.demo.TwoPigsStoryBackend.entity.DTO.message.CreateMessageRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.message.GetMessageListRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.PO.MessagePO;
import org.demo.TwoPigsStoryBackend.entity.VO.message.MessageListResponseVO;
import org.springframework.stereotype.Service;

@Service
public interface MessageService extends IService<MessagePO> {
    /**
     * 获取消息列表
     *
     * @param request 请求参数
     *
     * @return 消息列表
     */
    MessageListResponseVO getMessageList (GetMessageListRequestDTO request);
    
    /**
     * 创建新消息
     *
     * @param request 请求参数
     *
     * @return 是否成功创建
     */
    boolean createMessage (CreateMessageRequestDTO request);
    
    /**
     * 创建注册消息
     *
     * @param userId   用户ID
     * @param username 用户名
     *
     * @return 注册消息
     */
    boolean createRegisterMessage (Integer userId, String username);
    
    /**
     * 创建关注消息
     *
     * @param userId     用户ID
     * @param followerId 粉丝ID
     *
     * @return 是否成功创建关注消息
     */
    boolean createFollowMessage (Integer userId, Integer followerId);
    
    /**
     * 获取注册成功消息内容
     *
     * @param userId   用户ID
     * @param username 用户名
     *
     * @return 注册成功消息内容
     */
    String getRegisterMessage (Integer userId, String username);
}
