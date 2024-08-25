package org.demo.TwoPigsStoryBackend.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.demo.TwoPigsStoryBackend.entity.DTO.user.UserInfoRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.PO.UserPO;
import org.demo.TwoPigsStoryBackend.entity.VO.user.UserInfoResponseVO;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<UserPO> {
    /**
     * 获取用户信息
     *
     * @param request 请求参数
     *
     * @return 响应数据
     */
    UserInfoResponseVO getUserInfo (UserInfoRequestDTO request);
}
