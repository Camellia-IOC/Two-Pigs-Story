package org.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.demo.config.security.service.SecurityUtils;
import org.demo.entity.DTO.authentication.LoginRequestDTO;
import org.demo.entity.DTO.authentication.RegisterRequestDTO;
import org.demo.entity.PO.UserPO;
import org.demo.entity.VO.authentication.LoginResponseVO;
import org.demo.entity.VO.authentication.RegisterResponseVO;
import org.demo.mapper.AuthenticationMapper;
import org.demo.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationServiceImpl extends ServiceImpl<AuthenticationMapper, UserPO> implements AuthenticationService {
    @Resource
    private AuthenticationMapper authenticationMapper;
    
    /**
     * 用户登录
     *
     * @param request 请求参数
     *
     * @return permission 是否允许登录
     */
    @Override
    public LoginResponseVO userLogin (LoginRequestDTO request) {
        UserPO userInfo = authenticationMapper.getPasswordById(request.getUserId());
        LoginResponseVO loginResponseVO = new LoginResponseVO();
        
        // TODO:错误类型校验
        if (userInfo == null) {
            loginResponseVO.setPermission(false);
        }
        else {
            loginResponseVO.setPermission(SecurityUtils.matchPassword(request.getPassword(), userInfo.getPassword()));
        }
        
        return loginResponseVO;
    }
    
    /**
     * 用户注册
     *
     * @param request 请求参数
     *
     * @return userID 用户ID
     */
    @Override
    public RegisterResponseVO userRegister (RegisterRequestDTO request) {
        UserPO user = new UserPO();
        RegisterResponseVO registerResponseVO = new RegisterResponseVO();
        
        // 填充用户数据
        user.setUsername(request.getUserName());
        user.setPassword(SecurityUtils.encodePassword(request.getPassword()));
        user.setSex(null);
        user.setZone(null);
        user.setMate(null);
        user.setBirthday(null);
        user.setToken(null);
        
        if (authenticationMapper.insert(user) == 1) {
            registerResponseVO.setUserId(user.getId());
        }
        else {
            registerResponseVO.setUserId(null);
        }
        
        return registerResponseVO;
    }
}
