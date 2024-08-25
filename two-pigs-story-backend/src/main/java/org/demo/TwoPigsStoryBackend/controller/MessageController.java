package org.demo.TwoPigsStoryBackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.demo.TwoPigsStoryBackend.entity.DTO.message.GetMessageListRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.ResponseData;
import org.demo.TwoPigsStoryBackend.entity.VO.message.MessageListResponseVO;
import org.demo.TwoPigsStoryBackend.service.service.MessageService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "消息模块接口", description = "消息处理")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Resource
    private MessageService messageService;
    
    @Operation(summary = "获取消息列表")
    @GetMapping("/list")
    public ResponseData<MessageListResponseVO> list (@RequestBody GetMessageListRequestDTO request) {
        return ResponseData.success(messageService.getMessageList(request));
    }
}
