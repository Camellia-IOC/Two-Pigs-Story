package org.demo.TwoPigsStoryBackend.service.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.demo.TwoPigsStoryBackend.entity.PO.FriendPO;
import org.demo.TwoPigsStoryBackend.mapper.FriendMapper;
import org.demo.TwoPigsStoryBackend.service.service.FriendService;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, FriendPO> implements FriendService {
}
