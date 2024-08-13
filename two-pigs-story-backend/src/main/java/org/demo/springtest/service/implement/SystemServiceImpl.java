package org.demo.springtest.service.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.demo.springtest.entity.PO.UserPO;
import org.demo.springtest.entity.VO.system.LoginResponseVO;
import org.demo.springtest.entity.VO.system.RegisterResponseVO;
import org.demo.springtest.mapper.UserMapper;
import org.demo.springtest.service.service.SystemService;
import org.demo.springtest.entity.DTO.system.LoginRequestDTO;
import org.demo.springtest.entity.DTO.system.RegisterRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SystemServiceImpl extends ServiceImpl<UserMapper, UserPO> implements SystemService
{
    @Resource
    private UserMapper userMapper;
    
//    @Resource
//    private BCryptPasswordEncoder passwordEncoder;
    
    public LoginResponseVO userLogin (LoginRequestDTO request)
    {
        // TODO： 考虑一下能不能改成bean
        LoginResponseVO loginResponseVO = new LoginResponseVO();
        
        UserPO userInfo = userMapper.selectPasswordById(request.getUserID());
        if (userInfo == null)
        {
            loginResponseVO.setPermission(false);
        }
        else
        {
            loginResponseVO.setPermission(userInfo.getPassword().equals(request.getPassword()));
        }
        
        return loginResponseVO;
    }
    
    public RegisterResponseVO userRegister (RegisterRequestDTO request)
    {
        RegisterResponseVO registerResponseVO = new RegisterResponseVO();
        
        UserPO user = new UserPO();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUserName());
        user.setSex(null);
        user.setZone(null);
        user.setMate(null);
        user.setBirthday(null);
        
        if (userMapper.insert(user) == 1)
        {
            registerResponseVO.setUserID(user.getId());
        }
        else
        {
            registerResponseVO.setUserID(null);
        }
        
        return registerResponseVO;
    }
    
    public List<UserPO> userTest ()
    {
        return userMapper.selectAllUser();
    }
}
