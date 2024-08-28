package org.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.demo.entity.DTO.user.UserInfoRequestDTO;
import org.demo.entity.ResponseData;
import org.demo.entity.VO.user.UserInfoResponseVO;
import org.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户模块接口", description = "处理用户模块资源")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;
    
    @Operation(summary = "获取用户基本信息")
    @GetMapping("/userInfo")
    public ResponseData<UserInfoResponseVO> info (@RequestBody UserInfoRequestDTO request) {
        UserInfoResponseVO response = userService.getUserInfo(request);
        return ResponseData.success(response);
    }
}
