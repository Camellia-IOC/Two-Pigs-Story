package org.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.demo.entity.ResponseStatus;
import org.demo.entity.DTO.authentication.LoginRequestDTO;
import org.demo.entity.DTO.authentication.LogoutRequestDTO;
import org.demo.entity.DTO.authentication.RegisterRequestDTO;
import org.demo.entity.ResponseData;
import org.demo.entity.VO.authentication.LoginResponseVO;
import org.demo.entity.VO.authentication.LogoutResponseVO;
import org.demo.entity.VO.authentication.RegisterResponseVO;
import org.demo.logger.LoggerFactory;
import org.demo.service.AuthenticationService;
import org.demo.service.MessageService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户认证接口", description = "用户登录、用户注册")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {
    @Resource
    private AuthenticationService authenticationService;
    
    @Resource
    private MessageService messageService;
    
    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public ResponseData<LoginResponseVO> userLogin (@RequestBody LoginRequestDTO request) {
        LoginResponseVO response = authenticationService.userLogin(request);
        return ResponseData.success(response);
    }
    
    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public ResponseData<RegisterResponseVO> userRegister (@RequestBody RegisterRequestDTO request) {
        RegisterResponseVO response = authenticationService.userRegister(request);
        if (response.getUserId() == null) {
            return ResponseData.error(ResponseStatus.REGISTER_FAILED_ERROR);
        }
        else {
            // 创建新用户注册消息
            if (!messageService.createRegisterMessage(response.getUserId(),request.getUserName())) {
                LoggerFactory.logger.warn("注册消息生成失败");
            }
            
            return ResponseData.success(response);
        }
    }
    
    @Operation(summary = "用户退出")
    @PostMapping("/logout")
    public ResponseData<LogoutResponseVO> userLogout (@RequestBody LogoutRequestDTO request) {
        return null;
    }
}
