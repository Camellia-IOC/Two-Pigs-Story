package org.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.demo.entity.DTO.user.HandleMateInvitationRequestDTO;
import org.demo.entity.DTO.user.MateInvitationRequestDTO;
import org.demo.entity.DTO.zone.CloseZoneRequestDTO;
import org.demo.entity.DTO.zone.ConfigureZoneRequestDTO;
import org.demo.entity.DTO.zone.CreateZoneRequestDTO;
import org.demo.entity.DTO.zone.GetInvitationListRequestDTO;
import org.demo.entity.ENUM.ZoneStatusManager;
import org.demo.entity.PO.ZoneInvitationPO;
import org.demo.entity.PO.ZonePO;
import org.demo.entity.VO.zone.InvitationListResponseVO;
import org.demo.entity.VO.zone.ZoneMemberResponseVO;
import org.demo.mapper.ZoneInvitationMapper;
import org.demo.mapper.ZoneMapper;
import org.demo.service.ZoneService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ZoneServiceImpl extends ServiceImpl<ZoneMapper, ZonePO> implements ZoneService {
    @Resource
    private ZoneInvitationMapper zoneInvitationMapper;
    
    @Resource
    private ZoneMapper zoneMapper;
    
    /**
     * 返回邀请信息列表
     *
     * @param request 请求参数
     *
     * @return 邀请信息列表
     */
    @Override
    public InvitationListResponseVO getInvitationList (GetInvitationListRequestDTO request) {
        InvitationListResponseVO response = new InvitationListResponseVO();
        response.setInvitationList(zoneInvitationMapper.getInvitationListByUserId(request.getId()));
        
        return response;
    }
    
    /**
     * 发起空间开通邀请
     *
     * @param request 请求参数
     *
     * @return 是否发起成功
     */
    @Override
    public boolean sendMateInvitation (MateInvitationRequestDTO request) {
        ZoneInvitationPO invitation = new ZoneInvitationPO();
        
        // 初始化内容
        invitation.setSender(request.getSenderId());
        invitation.setReceiver(request.getReceiverId());
        invitation.setCreateTime(LocalDateTime.now());
        invitation.setStatus(-1);
        invitation.setHandleTime(null);
        
        return zoneInvitationMapper.insert(invitation) == 1;
    }
    
    /**
     * 同意空间开通请求
     *
     * @param request 请求参数
     *
     * @return 是否处理成功
     */
    @Override
    public boolean handleMateInvitation (HandleMateInvitationRequestDTO request) {
        return zoneInvitationMapper.updateInvitationStatus(request.getId(), request.getStatus(), LocalDateTime.now()) == 1;
    }
    
    /**
     * 创建空间
     *
     * @param request 请求参数
     *
     * @return 是否成功创建
     */
    @Override
    public boolean createMateZone (CreateZoneRequestDTO request) {
        ZonePO zone = new ZonePO();
        zone.setOwner(request.getOwner());
        zone.setMate(request.getMate());
        zone.setCreateTime(LocalDateTime.now());
        zone.setStatus(ZoneStatusManager.ACTIVE.getStatus());
        
        // 创建成功
        if (this.save(zone)) {
            return zoneMapper.assignZone(zone.getId(), request.getOwner(), request.getMate()) == 2;
        }
        
        return false;
    }
    
    /**
     * 关闭空间
     *
     * @param request 请求参数
     *
     * @return 是否成功关闭
     */
    @Override
    public boolean closeMateZone (CloseZoneRequestDTO request) {
        // 获取空间成员ID
        ZoneMemberResponseVO member = zoneMapper.getZoneMemberByZoneId(request.getId());
        
        if (zoneMapper.closeZone(request.getId()) == 1) {
            // TODO 还需要删除和该空间有关的其他表中的数据
            
            return zoneMapper.revokeZone(member.getOwner(), member.getMate()) == 2;
        }
        
        return false;
    }
    
    /**
     * 配置空间设置
     *
     * @param request 请求参数
     *
     * @return 是否成功修改
     */
    @Override
    public boolean configureMateZone (ConfigureZoneRequestDTO request) {
        // TODO:修改配置项
        return false;
    }
}
