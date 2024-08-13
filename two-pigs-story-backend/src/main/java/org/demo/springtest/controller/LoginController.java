package org.demo.springtest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.demo.springtest.entity.PO.UserPO;
import org.demo.springtest.entity.ResponseData;
import org.demo.springtest.entity.VO.system.LoginResponseVO;
import org.demo.springtest.entity.VO.system.RegisterResponseVO;
import org.demo.springtest.service.service.SystemService;
import org.demo.springtest.entity.DTO.system.LoginRequestDTO;
import org.demo.springtest.entity.DTO.system.RegisterRequestDTO;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录接口", description = "用户登录、用户注册")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController
{
    @Resource
    SystemService service;
    
    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public ResponseData<LoginResponseVO> userLogin (@RequestBody LoginRequestDTO request)
    {
        LoginResponseVO response = service.userLogin(request);
        return ResponseData.success(response);
    }
    
    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public ResponseData<RegisterResponseVO> userRegister (@RequestBody RegisterRequestDTO request)
    {
        RegisterResponseVO response = service.userRegister(request);
        return ResponseData.success(response);
    }
    
    @PostMapping("/test")
    public ResponseData<LoginResponseVO> test (@RequestBody LoginRequestDTO request)
    {
        return ResponseData.success();
    }
}
