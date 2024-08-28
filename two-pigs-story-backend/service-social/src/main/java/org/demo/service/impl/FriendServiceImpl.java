package org.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.demo.entity.PO.FriendPO;
import org.demo.mapper.FriendMapper;
import org.demo.service.FriendService;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, FriendPO> implements FriendService {
}
