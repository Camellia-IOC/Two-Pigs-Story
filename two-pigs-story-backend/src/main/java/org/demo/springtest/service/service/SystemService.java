package org.demo.springtest.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.demo.springtest.entity.PO.UserPO;
import org.demo.springtest.entity.VO.system.LoginResponseVO;
import org.demo.springtest.entity.VO.system.RegisterResponseVO;
import org.demo.springtest.entity.DTO.system.LoginRequestDTO;
import org.demo.springtest.entity.DTO.system.RegisterRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SystemService extends IService<UserPO>
{
    /**
     * 用户登录
     * @param request 请求参数
     * @return permission 是否允许登录
     */
    LoginResponseVO userLogin (LoginRequestDTO request);
    
    /**
     * 用户注册
     * @param request 请求参数
     * @return userID 用户ID
     */
    RegisterResponseVO userRegister (RegisterRequestDTO request);
    
    List<UserPO> userTest();
}
