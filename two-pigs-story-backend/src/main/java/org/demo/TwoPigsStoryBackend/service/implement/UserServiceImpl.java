package org.demo.TwoPigsStoryBackend.service.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.demo.TwoPigsStoryBackend.entity.DTO.user.UserInfoRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.PO.UserPO;
import org.demo.TwoPigsStoryBackend.entity.VO.user.MateBasicInfoResponseVO;
import org.demo.TwoPigsStoryBackend.entity.VO.user.UserInfoResponseVO;
import org.demo.TwoPigsStoryBackend.mapper.UserMapper;
import org.demo.TwoPigsStoryBackend.service.service.UserService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {
    @Resource
    private UserMapper userMapper;
    
    /**
     * 获取用户信息
     *
     * @param request 请求参数
     *
     * @return 响应数据
     */
    @Override
    public UserInfoResponseVO getUserInfo (UserInfoRequestDTO request) {
        UserPO userInfo = userMapper.getUserInfoById(request.getUserId());
        MateBasicInfoResponseVO userMate = userMapper.getMateInfoById(userInfo.getMate());
        
        UserInfoResponseVO userInfoResponseVO = new UserInfoResponseVO();
        
        userInfoResponseVO.setId(userInfo.getId());
        userInfoResponseVO.setUsername(userInfo.getUsername());
        userInfoResponseVO.setAvatar(userInfo.getAvatar());
        userInfoResponseVO.setIntro(userInfo.getIntroduction());
        userInfoResponseVO.setSex(userInfo.getSex());
        userInfoResponseVO.setBirthday(userInfo.getBirthday());
        userInfoResponseVO.setZone(userInfo.getZone());
        userInfoResponseVO.setMate(userMate);
        
        return userInfoResponseVO;
    }
}
