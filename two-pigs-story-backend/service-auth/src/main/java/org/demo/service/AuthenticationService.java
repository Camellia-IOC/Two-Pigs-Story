package org.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.demo.entity.DTO.authentication.LoginRequestDTO;
import org.demo.entity.DTO.authentication.RegisterRequestDTO;
import org.demo.entity.PO.UserPO;
import org.demo.entity.VO.authentication.LoginResponseVO;
import org.demo.entity.VO.authentication.RegisterResponseVO;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService extends IService<UserPO> {
    /**
     * 用户登录
     *
     * @param request 请求参数
     *
     * @return permission 是否允许登录
     */
    LoginResponseVO userLogin (LoginRequestDTO request);
    
    /**
     * 用户注册
     *
     * @param request 请求参数
     *
     * @return userID 用户ID
     */
    RegisterResponseVO userRegister (RegisterRequestDTO request);
}
