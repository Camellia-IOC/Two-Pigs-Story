package org.demo.TwoPigsStoryBackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.demo.TwoPigsStoryBackend.entity.DTO.user.AddFriendRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.user.UserInfoRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.ResponseData;
import org.demo.TwoPigsStoryBackend.entity.VO.user.UserInfoResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "好友模块", description = "处理好友模块相关操作")
@Slf4j
@Controller
@RestController
@RequestMapping("/api/friends")
public class FriendController {
    @Operation(summary = "添加好友")
    @PostMapping("/addFriend")
    public ResponseData<Object> addFriend (@RequestBody AddFriendRequestDTO request) {
        return ResponseData.success();
    }
    
    @Operation(summary = "处理好友请求")
    @PostMapping("/handleFriendRequest")
    public ResponseData<UserInfoResponseVO> handleFriendRequest (@RequestBody UserInfoRequestDTO request) {
        return ResponseData.success();
    }
}
