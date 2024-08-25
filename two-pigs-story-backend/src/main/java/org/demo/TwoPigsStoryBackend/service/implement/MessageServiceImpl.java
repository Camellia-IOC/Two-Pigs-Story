package org.demo.TwoPigsStoryBackend.service.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.demo.TwoPigsStoryBackend.entity.DTO.message.CreateMessageRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.message.GetMessageListRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.ENUM.BasicMessageTitleManager;
import org.demo.TwoPigsStoryBackend.entity.PO.MessagePO;
import org.demo.TwoPigsStoryBackend.entity.VO.message.MessageListResponseVO;
import org.demo.TwoPigsStoryBackend.mapper.MessageMapper;
import org.demo.TwoPigsStoryBackend.service.service.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessagePO> implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    
    /**
     * 获取消息列表
     *
     * @param request 请求参数
     *
     * @return 消息列表
     */
    @Override
    public MessageListResponseVO getMessageList (GetMessageListRequestDTO request) {
        MessageListResponseVO response = new MessageListResponseVO();
        response.setMessageList(messageMapper.getMessageListByReceiverId(request.getId()));
        
        return response;
    }
    
    /**
     * 创建新消息
     *
     * @param request 请求参数
     *
     * @return 是否成功创建
     */
    @Override
    public boolean createMessage (CreateMessageRequestDTO request) {
        MessagePO message = new MessagePO();
        message.setType(request.getType());
        message.setOrigin(request.getOrigin());
        message.setReceiver(request.getReceiver());
        message.setTitle(request.getTitle());
        message.setContent(request.getContent());
        message.setCreateTime(LocalDateTime.now());
        message.setReadFlag(0);
        
        return messageMapper.insert(message) == 1;
    }
    
    /**
     * 创建注册消息
     *
     * @param userId   用户ID
     * @param username 用户名
     *
     * @return 注册消息
     */
    @Override
    public boolean createRegisterMessage (Integer userId, String username) {
        CreateMessageRequestDTO message = new CreateMessageRequestDTO();
        message.setType(0);
        message.setOrigin(0);
        message.setReceiver(userId);
        message.setTitle(BasicMessageTitleManager.TITLE_REGISTER_MESSAGE.getTitle());
        message.setContent(this.getRegisterMessage(userId, username));
        
        return createMessage(message);
    }
    
    /**
     * 创建关注消息
     *
     * @param userId     用户ID
     * @param followerId 粉丝ID
     *
     * @return 是否成功创建关注消息
     */
    @Override
    public boolean createFollowMessage (Integer userId, Integer followerId) {
        CreateMessageRequestDTO message = new CreateMessageRequestDTO();
        message.setType(0);
        message.setOrigin(followerId);
        message.setReceiver(userId);
        message.setTitle(BasicMessageTitleManager.TITLE_FOLLOW_MESSAGE.getTitle());
        message.setContent("你有新的粉丝啦，快来看看吧！");
        
        return createMessage(message);
    }
    
    
    /**
     * 获取注册成功消息内容
     *
     * @param userId   用户ID
     * @param username 用户名
     *
     * @return 注册成功消息内容
     */
    @Override
    public String getRegisterMessage (Integer userId, String username) {
        return "Hello " +
                       username +
                       "!" +
                       "欢迎你加入我们的大家庭,你的ID是：" +
                       userId +
                       ",请注意保存噢~";
    }
}