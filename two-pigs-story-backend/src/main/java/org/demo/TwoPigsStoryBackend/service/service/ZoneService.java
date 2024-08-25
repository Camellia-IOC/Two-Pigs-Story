package org.demo.TwoPigsStoryBackend.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.demo.TwoPigsStoryBackend.entity.DTO.user.HandleMateInvitationRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.user.MateInvitationRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.zone.CloseZoneRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.zone.ConfigureZoneRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.zone.CreateZoneRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.DTO.zone.GetInvitationListRequestDTO;
import org.demo.TwoPigsStoryBackend.entity.PO.ZonePO;
import org.demo.TwoPigsStoryBackend.entity.VO.zone.InvitationListResponseVO;
import org.springframework.stereotype.Service;

@Service
public interface ZoneService extends IService<ZonePO> {
    /**
     * 返回邀请信息列表
     *
     * @param request 请求参数
     *
     * @return 邀请信息列表
     */
    InvitationListResponseVO getInvitationList (GetInvitationListRequestDTO request);
    
    /**
     * 发起成为伴侣请求
     *
     * @param request 请求参数
     *
     * @return 是否发起成功
     */
    boolean sendMateInvitation (MateInvitationRequestDTO request);
    
    /**
     * 同意成为伴侣请求
     *
     * @param request 请求参数
     *
     * @return 是否处理成功
     */
    boolean handleMateInvitation (HandleMateInvitationRequestDTO request);
    
    /**
     * 创建空间
     *
     * @param request 请求参数
     *
     * @return 是否成功创建
     */
    boolean createMateZone (CreateZoneRequestDTO request);
    
    /**
     * 关闭空间
     *
     * @param request 请求参数
     *
     * @return 是否成功关闭
     */
    boolean closeMateZone (CloseZoneRequestDTO request);
    
    /**
     * 配置空间设置
     *
     * @param request 请求参数
     *
     * @return 是否成功修改
     */
    boolean configureMateZone (ConfigureZoneRequestDTO request);
}
