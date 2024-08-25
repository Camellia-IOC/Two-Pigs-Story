package org.demo.TwoPigsStoryBackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.demo.TwoPigsStoryBackend.entity.DTO.user.HandleMateInvitationRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.user.MateInvitationRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.zone.CloseZoneRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.zone.ConfigureZoneRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.zone.CreateZoneRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.zone.GetInvitationListRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.ENUM.ZoneInvitationStatusManager;
import org.demo.TwoPigsStoryBackend.entity.ResponseData;
import org.demo.TwoPigsStoryBackend.entity.ResponseStatus;
import org.demo.TwoPigsStoryBackend.entity.VO.zone.InvitationListResponseVO;
import org.demo.TwoPigsStoryBackend.mapper.ZoneInvitationMapper;
import org.demo.TwoPigsStoryBackend.mapper.ZoneMapper;
import org.demo.TwoPigsStoryBackend.service.service.ZoneService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Tag(name = "空间管理模块", description = "空间管理")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/zone")
public class ZoneController {
    @Resource
    private ZoneService zoneService;
    
    @Resource
    private ZoneMapper zoneMapper;
    
    @Resource
    private ZoneInvitationMapper zoneInvitationMapper;
    
    @Operation(summary = "获取邀请信息列表")
    @GetMapping("/invitations")
    public ResponseData<InvitationListResponseVO> getInvitations (@RequestBody GetInvitationListRequestDTO request) {
        // TODO：考虑逻辑是否需要修改
        InvitationListResponseVO response = zoneService.getInvitationList(request);
        
        return ResponseData.success(response);
    }
    
    @Operation(summary = "发起空间开通邀请")
    @PostMapping("/invite")
    public ResponseData<Object> invite (@RequestBody MateInvitationRequestDTO request) {
        if (zoneService.sendMateInvitation(request)) {
            return ResponseData.success();
        }
        
        return ResponseData.error(ResponseStatus.INVITE_FAILED_ERROR);
    }
    
    @Operation(summary = "处理空间邀请请求")
    @PutMapping("/handleInvitation")
    public ResponseData<Object> handleInvitation (@RequestBody HandleMateInvitationRequestDTO request) {
        // 判断是否已经处理过该请求
        if (zoneInvitationMapper.getInvitationStatusById(request.getId()) != ZoneInvitationStatusManager.DEFAULT.getStatus()) {
            return ResponseData.error(ResponseStatus.INVITATION_HAS_BEEN_HANDLED);
        }
        
        // 接受邀请
        if (zoneService.handleMateInvitation(request)) {
            if (request.getStatus() == 1) {
                CreateZoneRequestDTO createParam = new CreateZoneRequestDTO();
                createParam.setOwner(request.getSender());
                createParam.setMate(request.getReceiver());
                createParam.setCreateTime(LocalDateTime.now());
                
                // 创建空间
                if (zoneService.createMateZone(createParam)) {
                    return ResponseData.success();
                }
                
                // TODO:创建失败需要回滚
                return ResponseData.error(ResponseStatus.ZONE_CREATE_FAILED_ERROR);
            }
            // 拒绝邀请
            else if (request.getStatus() == 0) {
                return ResponseData.success();
            }
        }
        
        return ResponseData.error(ResponseStatus.INVITATION_HANDLE_FAILED_ERROR);
    }
    
    @Operation(summary = "关闭空间")
    @DeleteMapping("/close")
    public ResponseData<Object> closeZone (@RequestBody CloseZoneRequestDTO request) {
        if (zoneService.closeMateZone(request)) {
            return ResponseData.success();
        }
        
        return ResponseData.error(ResponseStatus.ZONE_CLOSE_FAILED_ERROR);
    }
    
    @Operation(summary = "修改空间信息")
    @PostMapping("/configure")
    public ResponseData<Object> configureZone (@RequestBody ConfigureZoneRequestDTO request) {
        if (zoneService.configureMateZone(request)) {
            return ResponseData.success();
        }
        
        return ResponseData.error(ResponseStatus.ZONE_CONFIGURE_FAILED_ERROR);
    }
}
